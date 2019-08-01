package steve.spring.jpa.springboot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableScheduling
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }
    @Bean
    public Jedis jRedis(){
        return new Jedis("localhost", 6379);
    }
}
