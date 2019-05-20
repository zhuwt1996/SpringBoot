package com.szu.springboot.test;

import com.szu.springboot.model.User;
import com.szu.springboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by zhuwutao on 2019/5/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserReposityTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void testJpa() {
        System.out.println(userRepository.findByUserName("aa"));

        System.out.println(userRepository.findByUserNameOrEmail("zz", "1255284280@qq.com"));

    }

    @Test
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("dd", "aa123456","aa@126.com", "aa",  formattedDate));
        userRepository.save(new User("ff", "bb123456","bb@126.com", "bb",  formattedDate));
        userRepository.save(new User("ee", "cc123456","cc@126.com", "cc",  formattedDate));

//		Assert.assertEquals(3, userRepository.findAll().size());
//		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
//		userRepository.delete(userRepository.findByUserName("aa"));
    }


    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user=new User("ff", "ff123456","ff@126.com", "ff",  formattedDate);
        userRepository.findAll();
        userRepository.findById(3L);
        userRepository.save(user);
        //user.setId(2L);
        //userRepository.delete(user);
        userRepository.count();
        userRepository.existsById(3L);
    }

    @Test
    public void testCustomSql() {
        System.out.println(userRepository.modifyById("zhuwutao", 1L));
        userRepository.deleteById(7L);
        userRepository.findByEmail("ff@126.com");
    }





    @Test
    public void testPageQuery()  {
        int page=1,size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByNickName("aa", pageable);
    }
}
