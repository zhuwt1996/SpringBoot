package com.szu.springboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Component
@RabbitListener(queues = "zhuwutao.topic1")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("receive1 message:" + message);
    }
}
