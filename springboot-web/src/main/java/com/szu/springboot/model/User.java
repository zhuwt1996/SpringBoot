package com.szu.springboot.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhuwutao on 2019/5/17
 */
@Entity
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public User(String nickName,String email,String userName,  String passWord, String regTime) {
        super();
        this.email = email;
        this.nickName = nickName;
        this.passWord = passWord;
        this.userName = userName;
        this.regTime = regTime;
    }

    public User() {
    }
}
