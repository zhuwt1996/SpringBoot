package com.szu.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Component
public class SchaduleTask1 {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

}
