package com.szu.springboot.bean;

import java.io.Serializable;

/**
 * Created by zhuwutao on 2019/5/22
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;
    private String passWord;
    private String nickName;

    public User() {
        super();
    }

    public User(String userName, String passWord ) {
        super();
        this.passWord = passWord;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
