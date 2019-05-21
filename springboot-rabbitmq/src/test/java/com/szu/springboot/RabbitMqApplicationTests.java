package com.szu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhuwutao on 2019/5/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqApplicationTests {

    @Test
    public void contextLoads(){
        System.out.println("hello world");
    }
}
