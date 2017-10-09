package com.frank.chapter21.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jianweilin on 2017/10/9.
 */
@Component
public class BlogService {

    @Value("${com.frank.blog.name}")
    private String name;
    @Value("${com.frank.blog.title}")
    private String title;
    @Value("${com.frank.blog.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
