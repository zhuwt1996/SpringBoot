package com.szu.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuwutao on 2019/5/21
 */
@Component
public class SchaduleTask2 {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}

