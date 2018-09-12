package com.frank.chapter413.controller;

import com.frank.chapter413.domain.City;
import com.frank.chapter413.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/9/12
 */
@RestController
public class CityController {

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/getCitys")
    public List<City> getCitys(){
        return cityMapper.getAll();
    }
}
