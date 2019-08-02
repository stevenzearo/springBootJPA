package steve.spring.jpa.springboot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.Jedis;
import steve.spring.jpa.springboot_jpa.config.StandaloneRedisConfig;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@EnableCaching
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }
    @Bean
    public Jedis jRedis(){
        return new Jedis("localhost", 6379);
    }
    @Bean
    public StandaloneRedisConfig getRedisConfig(){
        StandaloneRedisConfig redisConfig = new StandaloneRedisConfig();
        return redisConfig;
    }
}
