package steve.spring.jpa.springboot_jpa;

import org.databene.contiperf.PerfTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 17:13
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private Jedis jedis;
    @Test
    @PerfTest(invocations = 100, threads = 100)
    public void testString(){
        jedis.set("hello", "world");
        System.out.println(jedis.get("hello"));
    }

    @Test
    public void stringGetTest(){
        String ticketNum = jedis.get("ticketNum");
        if (ticketNum != null) {

            System.out.println(ticketNum);
        } else {
            System.out.println("ticketNum is null");
        }

    }
}
