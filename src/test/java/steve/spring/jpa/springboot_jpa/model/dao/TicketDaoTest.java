package steve.spring.jpa.springboot_jpa.model.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;

import static org.junit.Assert.*;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:41
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketDaoTest {
    @Autowired
    private TicketDao ticketDao;
    @Test
    public void get5Ticket(){
        Page<TicketInfo> all = ticketDao.findAll(PageRequest.of(0, 5));
        Logger logger = LoggerFactory.getLogger(this.getClass());
        all.getContent().forEach(ticketInfo -> logger.info("------->" + ticketInfo));
    }
    @Test
    public void countByTicketStatus(){
        Integer count = ticketDao.countByTicketStatus("0");
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("------>count:" + count);
    }
    @Test
    public void findAll(){
        Page<TicketInfo> ticketInfos = ticketDao.findByTicketStatusOrderByTicketTimeAsc("0", PageRequest.of(1, 160));
        Logger logger = LoggerFactory.getLogger(this.getClass());
        ticketInfos.getContent().forEach(ticketInfo -> logger.info("------->" + ticketInfo));
        System.out.println(ticketInfos.getNumber());
        System.out.println(ticketInfos.getNumberOfElements());
        System.out.println(ticketInfos.getSize());

    }
    @Test
    public void findOldestTicketByTicketStatus(){
        TicketInfo ticketInfo = ticketDao.findOldestTicketByTicketStatus("0");
        Logger logger = LoggerFactory.getLogger(this.getClass());
        System.out.println(ticketInfo);

    }
}