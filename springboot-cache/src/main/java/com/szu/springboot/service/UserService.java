package com.szu.springboot.service;

import com.szu.springboot.bean.User;
import com.szu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    /**
     * @Cacheable：
     * 1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
     *    （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     * 2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
     *    key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key；
     *      SimpleKeyGenerator生成key的默认策略；
     *            如果没有参数；key=new SimpleKey()；
     *            如果有一个参数：key=参数的值
     *            如果有多个参数：key=new SimpleKey(params)；
     * 3、没有查到缓存就调用目标方法；
     * 4、将目标方法返回的结果，放进缓存中
     *
     * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     * 如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     * 核心：
     *     1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
     *     2）、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     * 几个属性：
     *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *             编写SpEL； #i d;参数id的值   #a0  #p0  #root.args[0]
     *              getEmp[2]
     *
     *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator：二选一使用;
     *
     *
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *
     *      condition：指定符合条件的情况下才缓存；
     *              ,condition = "#id>0"
     *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *              unless = "#result == null"
     *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      sync：是否使用异步模式
     *
     */
//    @Cacheable(value = {"user"})
//    public User getUserById(Integer id){
//        System.out.println("查询id为"+ id +"的用户");
//        User user = userMapper.findUser(id);
//
//        return user;
//    }

    // 使用缓存管理器得到缓存，进行api调用
    public User getUserById(Integer id){
        System.out.println("查询id为"+ id +"的用户");
        User user = userMapper.findUser(id);

        Cache cache = userRedisCacheManager.getCache("user");
        cache.put("dept:1",user);

        return user;
    }

    /**
     * @CachePut：既调用方法，又更新缓存数据；同步更新缓存
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     *
     * 测试步骤：
     *  1、查询1号员工；查到的结果会放在缓存中；
     *          key：1  value：lastName：张三
     *  2、以后查询还是之前的结果
     *  3、更新1号员工；【lastName:zhangsan；gender:0】
     *          将方法的返回值也放进缓存了；
     *          key：传入的employee对象  值：返回的employee对象；
     *  4、查询1号员工？
     *      应该是更新后的员工；
     *          key = "#employee.id":使用传入的参数的员工id；
     *          key = "#result.id"：使用返回后的id
     *             @Cacheable的key是不能用#result
     *      为什么是没更新前的？【1号员工没有在缓存中更新】
     *
     */
    @CachePut(value = "user",key = "#result.id")
    public User updateUser(User user){
        Cache.ValueWrapper wrapper = userRedisCacheManager.getCache("user").get(user.getId());
        System.out.println(wrapper);
        System.out.println("更新用户为："+user);
        userMapper.updateUser(user);

        return user;
    }

    /**
     * @CacheEvict：缓存清除
     *  key：指定要清除的数据
     *  allEntries = true：指定清除这个缓存中所有的数据
     *  beforeInvocation = false：缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     *
     *  beforeInvocation = true：
     *      代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     *
     *
     */
    @CacheEvict(value = "user",beforeInvocation = false)
    public void deleteUser(Integer id){
        System.out.println("删除id为"+ id + "的用户");
//        userMapper.deleteUser(id);
        int i=1/0;
    }

    // @Caching 定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(value={"user"})
            }/*,
            put = {
                    @CachePut(*//*value="emp",*//*key = "#result.id"),
                    @CachePut(*//*value="emp",*//*key = "#result.nickName")
            }*/
    )
    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }


}
