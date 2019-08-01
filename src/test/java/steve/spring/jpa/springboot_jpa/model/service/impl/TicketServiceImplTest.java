package steve.spring.jpa.springboot_jpa.model.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import steve.spring.jpa.springboot_jpa.model.service.TicketService;

/**
 * @Author steve
 * @Date 2019/8/1
 * @Time 16:55
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceImplTest {
    @Autowired
    private TicketService ticketService;
    @Test
    public void getTicket() {
    }

    @Test
    public void startServiceByDB() {
    }

    @Test
    public void startServiceByCache() {
        ticketService.startServiceByCache();
    }


}