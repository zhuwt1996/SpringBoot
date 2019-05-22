package com.szu.springboot.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuwutao on 2019/5/22
 */
@Component   //加入到容器中，服务启动便可以加载
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(){
        String message1 = "这条消息两个消费者都不可以消费到";
        System.out.println("message1: " + message1);
        /**
         *
         * @param exchange the name of the exchange
         * @param routingKey the routing key
         * @param message a message to send
         */
        amqpTemplate.convertAndSend("topicExchange","zhuwutao.topic",message1);
    }

    public void send2(){
        String message1 = "这条消息topic1可以消费到";
        System.out.println("message1: " + message1);
        /**
         *
         * @param exchange the name of the exchange
         * @param routingKey the routing key
         * @param message a message to send
         */
        amqpTemplate.convertAndSend("topicExchange","zhuwutao.topic1",message1);
    }

    public void send3(){
        String message1 = "这条消息topic2可以消费到";
        System.out.println("message1: " + message1);
        /**
         *
         * @param exchange the name of the exchange
         * @param routingKey the routing key
         * @param message a message to send
         */
        amqpTemplate.convertAndSend("topicExchange","zhuwutao.topic2",message1);
    }

}
