package com.szu.springboot.property;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhuwutao on 2019/5/17
 */
@Component  //添加进容器中
@Data
public class MyProperties {

    @Value("${com.szu.title}")
    private String title;

    @Value("${com.szu.description}")
    private String description;

}
