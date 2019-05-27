package com.szu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhuwutao on 2019/5/22
 *
 *
 * Springboot整合缓存
 *
 * 一、环境搭建
 * 1、创建数据库user表
 * 2、创建JavaBean对象
 * 3、整合mybatis操作数据库
 *    1、配置数据源
 *    2、开启mapper扫描 ： 主启动类@MapperScan  or mapper类@Mapper
 * 二、springboot自带的缓存
 * 1、主启动类开启缓存注解：@EnableCaching
 * 2、标注缓存注解 @Cacheable @CacheEvict @CachePut
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在	ConcurrentMap<Object, Object>中
 *
 */
@SpringBootApplication
@EnableCaching  //开启缓存
@MapperScan("com.szu.springboot.mapper")
@EnableSwagger2  //开启swagger
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class,args);
    }
}
