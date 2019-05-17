package com.szu.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuwutao on 2019/5/17
 */
@RestController //返回json字符串
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot!!!";
    }
}
