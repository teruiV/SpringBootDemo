package com.frank.chapter21.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jianweilin on 2017/10/9.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public String index(){
        return "Hello World!";
    }
}
