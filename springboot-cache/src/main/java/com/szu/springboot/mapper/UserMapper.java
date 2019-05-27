package com.szu.springboot.mapper;

import com.szu.springboot.bean.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUers();

    @Select("select * from user where id = #{id}")
    User findUser(Integer id);

    @Insert("insert into user(userName,passWord) values(#{userName}, #{passWord}) ")
    void insertUser(User user);

    @Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void  deleteUser(Integer id);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);
}
