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
 * 三、整合redis作为缓存
 * 1、启动redis
 * 2、原理：CacheManager == Cache 缓存组件
 *   1）、引入redis的starter，容器中保存的是RedisCacheManager
 *   2）、RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件；RedisCache通过操作redis缓存数据的
 *   3）、默认保存数据 k-v 都是Object；利用序列化保存；如何保存为json
 *   			1、引入了redis的starter，cacheManager变为 RedisCacheManager；
 *   			2、默认创建的 RedisCacheManager 操作redis的时候使用的是 RedisTemplate<Object, Object>
 *   			3、RedisTemplate<Object, Object> 是 默认使用jdk的序列化机制
 *   4）、自定义CacheManager；
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
