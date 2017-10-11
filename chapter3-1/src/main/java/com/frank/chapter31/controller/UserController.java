package com.frank.chapter31.controller;

import com.alibaba.fastjson.JSON;
import com.frank.chapter31.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jianweilin on 2017/10/11.
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> getUserList(){
        return User.initUsers();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        logger.info("user => " + JSON.toJSONString(user));
        return "add success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        logger.info("userId => " + id);
        return new User(id,"init",0);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User putUser(@PathVariable Long id,@ModelAttribute User user) {
        logger.info("userId => " + id);
        return new User(id,user.getName(),user.getAge());
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        logger.info("delte userId => " + id);
        return "delete success";
    }
}
