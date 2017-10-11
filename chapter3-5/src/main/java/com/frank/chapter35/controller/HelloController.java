package com.frank.chapter35.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by jianweilin on 2017/10/11.
 */
@Api(value = "Hello接口模块")
@RestController
public class HelloController {

//    @ApiImplicitParams(
//            value = {
//                    @ApiImplicitParam(paramType = "header",name="User-Id",required = true,dataType = "string"),
//                    @ApiImplicitParam(paramType = "header",name="User-Token",required = true,dataType = "string")
//            }
//    )
    @ApiOperation(value = "hello world接口",notes = "swagger文档，请访问http://localhost:8080/swagger-ui.html")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(@ApiParam(value = "名字",required = true)@RequestParam String name){
        return "Hello World: " + name ;
    }

}
