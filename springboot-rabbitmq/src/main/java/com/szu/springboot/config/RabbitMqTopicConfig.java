package com.szu.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by zhuwutao on 2019/5/22
 */
@Configuration
public class RabbitMqTopicConfig {


    final static String topic1 = "zhuwutao.topic1";
    final static String topic2 = "zhuwutao.topic2";

    @Bean
    public Queue topicQueue1(){
        return new Queue(topic1);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(topic2);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("TopicExchange");
    }

    //topicQueue1与交换器进行绑定，路由键为zhuwutao.topic1
    @Bean
    Binding bindingExchangeMessage1(Queue topicQueue1, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("zhuwutao.topic1");

    }

    //topicQueue2与交换器进行绑定，路由键为zhuwutao.topic2
    @Bean
    Binding bindingExchangeMessage2(Queue topicQueue2, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("zhuwutao.topic2");

    }
}
