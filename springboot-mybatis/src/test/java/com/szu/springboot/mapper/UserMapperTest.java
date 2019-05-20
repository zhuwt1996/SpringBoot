package com.szu.springboot.mapper;

import com.szu.springboot.enums.UserSexEnum;
import com.szu.springboot.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhuwutao on 2019/5/20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc1", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.findAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.findAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(30l);
        System.out.println(user.toString());
        user.setNickName("zhuwutao");
        userMapper.update(user);
        Assert.assertTrue(("zhuwutao".equals(userMapper.getOne(30l).getNickName())));
    }
}
