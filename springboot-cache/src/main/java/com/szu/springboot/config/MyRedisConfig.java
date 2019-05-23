package com.szu.springboot.config;

import com.szu.springboot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by zhuwutao on 2019/5/22
 */
@Configuration
public class MyRedisConfig {

    @Bean(name = "userRedisTemplate")
    public RedisTemplate<Object, User> userRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Bean(name = "userCacheManager")
    public RedisCacheManager userCacheManager(RedisTemplate<Object, User> userRedisTemplate){
        RedisCacheManager  cacheManager = new RedisCacheManager(userRedisTemplate);

        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
}
