package com.szu.springboot.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "hello" + new Date();
        System.out.println("message:" + message);
        amqpTemplate.convertAndSend("hello",message);
    }
}
