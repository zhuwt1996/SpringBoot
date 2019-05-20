package com.szu.springboot.mapper;

import com.szu.springboot.enums.UserSexEnum;
import com.szu.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

   /* @Select("select * from users")
    @Results({
            @Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
            @Result(property = "nickName",column = "nick_name")
    })*/
    List<User> findAll();

    /*@Select("select * from users where id = #{id}")
    @Results({
            @Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
            @Result(property = "nickName",column = "nick_name")
    })*/
    User getOne(Long id);

//    @Insert("insert into users(userName,passWord,user_sex) values(#{userName}, #{passWord}, #{userSex}) ")
    void insert(User user);

//    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

//    @Delete("DELETE FROM users WHERE id =#{id}")
    void  delete(Long id);
}
