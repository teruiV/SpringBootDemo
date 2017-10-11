package com.frank.chapter34.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jianweilin on 2017/10/11.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.addAttribute("host","http://www.jianwl.com");
        return "index";
    }

}
