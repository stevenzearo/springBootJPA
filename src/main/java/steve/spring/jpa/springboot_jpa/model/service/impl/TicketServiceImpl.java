package steve.spring.jpa.springboot_jpa.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import steve.spring.jpa.springboot_jpa.model.dao.TicketDao;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;
import steve.spring.jpa.springboot_jpa.model.service.TicketService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:23
 * @Version 1.0
 */
public class TicketServiceImpl implements TicketService {
	@Autowired
	private static TicketDao ticketDao;
	@Autowired
	private static Jedis jedis;

	static {
		init();
	}

	@Override
	@Transactional
	public TicketInfo getTicket(String ticketType) {
		String ticketId = UUID.randomUUID().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String ticketTime = dateFormat.format(new Date());
		TicketInfo ticketInfo = new TicketInfo(ticketId, ticketType, ticketTime, "0");
		ticketDao.save(ticketInfo);

		return ticketInfo;
	}

	@Override
	@Transactional
	public synchronized String startServiceByDB() {
		/**
		 * synchronized常用方式
		 * 1.静态方法加上关键字
		 * 2.实例方法（也就是普通方法）加上关键字
		 * 3.方法中使用同步代码块（锁对象相当于一个监视者，锁对象的引用在同步块中尽量保持不变，若锁对象的引用发生改变则锁被释放,常用synchronized(this){}）
 		 */
		String resultTicketId = "";
		TicketInfo ticketInfo = ticketDao.findOldestTicketByTicketStatus("0");
		if (ticketInfo != null) {
			ticketInfo.setTicketStatus("1");
			ticketDao.save(ticketInfo);
			resultTicketId = ticketInfo.getTicketId();
		}
		return resultTicketId;
	}

	@Override
	@Transactional
	public String startServiceByCache() {
		// 注：在缓存中存在大量读的业务，在数据库中存在大量写的任务，读写分离，不存在线程冲突问题
		String resultTicketId = "";
		int bound = 100;
		// 从缓存中读取数据
		int totalNum = ticketDao.countByTicketStatus("0");
		if (totalNum < bound) {
			//数据量太小时使用缓存反而影响运行效率
			resultTicketId = startServiceByDB();
		} else {


			String ticketId = jedis.rpop("ticketId");
			String ticketType = jedis.hget(ticketId, "ticketType");
			String ticketTime = jedis.hget(ticketId, "ticketTime");
			String ticketStatus = jedis.hget(ticketId, "ticketStatus");
			TicketInfo ticketInfo = new TicketInfo(ticketId, ticketId, ticketTime, "1");
			// 为了保证数据的完整性此处不能使用短路与
			if (ticketId != null & ticketType != null & ticketTime != null & ticketStatus != null) {
				ticketDao.save(ticketInfo);
				resultTicketId = ticketId;
			} else {
				// 缓存中的数据已被读完需要重新加载
				init();
				resultTicketId = startServiceByCache();
			}
		}
		return resultTicketId;
	}

	// 缓存初始化方法,只允许单线程进入
	private static synchronized void init() {
		int cacheNum = 100;
		// 总的已取票未叫号条数
		Page<TicketInfo> ticketInfoPage = ticketDao.findByTicketStatusOrderByTicketTimeAsc("0", PageRequest.of(0, cacheNum));
		List<TicketInfo> ticketInfoList = ticketInfoPage.getContent();
		for (TicketInfo ticketInfo :
				ticketInfoList) {
			// 缓存中数据id的列表的添加
			jedis.lpush("ticketId", ticketInfo.getTicketId());
			// 缓存中数据的hash
			HashMap<String, String> hashMap = new HashMap<>();
			hashMap.put("ticketType", ticketInfo.getTicketType());
			hashMap.put("ticketTime", ticketInfo.getTicketTime());
			hashMap.put("ticketStatus", ticketInfo.getTicketStatus());
			jedis.hmset(ticketInfo.getTicketId(), hashMap);

		}
	}

}
