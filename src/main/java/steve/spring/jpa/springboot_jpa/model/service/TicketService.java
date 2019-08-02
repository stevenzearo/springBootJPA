package steve.spring.jpa.springboot_jpa.model.service;

import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 17:43
 * @Version 1.0
 */
public interface TicketService {

    // 取票

    /**
     * 取票
     * @return 票信息
     */
    TicketInfo getTicket(String ticketType);

    /**
     * 叫号(开始业务)-数据库
     * @return 叫号票的id
     */
    String startServiceByDB();

    /**
     * 叫号(开始业务)-缓存
     * @return 叫号的票的id
     */
    String startServiceByCache();

    void cacheInit();
}
