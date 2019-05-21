package com.szu.springboot.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
