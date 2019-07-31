package steve.spring.jpa.springboot_jpa.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import steve.spring.jpa.springboot_jpa.model.dao.TicketDao;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInCache;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;
import steve.spring.jpa.springboot_jpa.model.service.TicketService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:23
 * @Version 1.0
 */
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private Jedis jedis;
    @Override
    @Transactional
    public TicketInfo getTicket(String ticketType) {
        Integer cacheSum = 10;
        String ticketId = UUID.randomUUID().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String ticketTime = dateFormat.format(new Date());
        TicketInfo ticketInfo = new TicketInfo(ticketId, ticketType, ticketTime, "0");
        ticketDao.save(ticketInfo);
        // 缓存中只存10条数据供取出
        // 存的时候先查缓存中存入列表的数据条数，取出列表的数据条数
        Integer dataNum = 0;
        String dataNumStr = jedis.get("dataNum");
        if (dataNumStr != null) {
            dataNum = Integer.valueOf(dataNumStr);
        }
        if (dataNum < cacheSum) {

        } else {

        }
        return ticketInfo;
    }

    @Override
    public Boolean startServiceByDB() {
        return null;
    }

    @Override
    public Boolean startServiceByCache() {
        return null;
    }

}
