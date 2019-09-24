package com.idwxy.logindemo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonInclude(Include.NON_DEFAULT)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    // 自增 id
    private Integer id;
    // 用户昵称
    private String name;
    // 性别
    private Integer gender;
    // 年龄
    private Integer age;
    // 密码
    private String password;

    // 构造函数
    public User() {
        super();
    }

    public User(String name, Integer gender, Integer age, String password) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "User [id=" + id +
                ", name=" + name +
                ", gender=" + gender +
                ", age=" + age +
                ", password" + password + "]";
    }
}
