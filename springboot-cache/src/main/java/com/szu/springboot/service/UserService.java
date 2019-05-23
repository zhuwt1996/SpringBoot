package com.szu.springboot.service;

import com.szu.springboot.bean.User;
import com.szu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * Created by zhuwutao on 2019/5/22
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisCacheManager userRedisCacheManager;

    @Cacheable(value = {"user"})
    public User getUserById(Long id){
        System.out.println("查询id为"+ id +"的用户");
        User user = userMapper.findUser(id);

        return user;
    }

    @Cacheable(value = {"user"},key = "#result.id")
    public User updateUser(User user){
        System.out.println("更新用户为："+user);
        userMapper.updateUser(user);

        return user;
    }


}
