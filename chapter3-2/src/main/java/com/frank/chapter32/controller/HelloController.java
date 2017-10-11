package com.frank.chapter32.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jianweilin on 2017/10/11.
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","http://www.jianwl.com");
        return "index";
    }
}
