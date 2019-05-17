package com.szu.springboot.web;

import com.szu.springboot.property.MyProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

	@Autowired
    private MyProperties myProperties;

    @Test
    public void getHello() throws Exception {
    	System.out.println(myProperties.getTitle());
        Assert.assertEquals(myProperties.getTitle(), "ShenZhen University");
        Assert.assertEquals(myProperties.getDescription(), "深圳大学");
    }


}