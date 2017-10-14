package com.frank.chapter49.service;

import com.frank.chapter49.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jianweilin on 2017/10/14.
 */
public interface UserService {
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    User login(String name,String password);
}
