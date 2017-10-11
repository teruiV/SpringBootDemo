package com.frank.chapter41.service;

/**
 * Created by jianweilin on 2017/10/11.
 */
public interface UserService {

    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

    void deleteAllUsers();
}
