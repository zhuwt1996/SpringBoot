package com.szu.springboot.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Component
public class MySender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i){
        String message = "my queue1"+" ------ "+i;
        System.out.println("sender1: " + message);
        amqpTemplate.convertAndSend("wutao",message);
    }
}
