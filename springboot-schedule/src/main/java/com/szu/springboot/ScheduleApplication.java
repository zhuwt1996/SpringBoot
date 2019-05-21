package com.szu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by zhuwutao on 2019/5/21
 */
@SpringBootApplication
@EnableScheduling   //开启定时任务
public class ScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class,args);
    }
}
