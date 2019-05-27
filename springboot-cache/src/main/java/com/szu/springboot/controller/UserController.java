package com.szu.springboot.controller;

import com.szu.springboot.bean.User;
import com.szu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhuwutao on 2019/5/22
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public User updateUser(User user){
        System.out.println(user);
        return userService.updateUser(user);
    }

}
