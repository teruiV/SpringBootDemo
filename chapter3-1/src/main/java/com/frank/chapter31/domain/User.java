package com.frank.chapter31.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jianweilin on 2017/10/11.
 */
public class User {
    private Long id;
    private String name;
    private Integer age;

    public static List<User> initUsers(){
        return Arrays.asList(new User(1L, "张三", 21), new User(2L, "李四", 22));
    }

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
