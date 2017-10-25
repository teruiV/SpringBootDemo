package com.frank.chapter411.service;

import com.frank.chapter411.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author jianweilin
 * @date 2017/10/24
 */
public interface UserService {
    User save(User user);

    void deleteByUserId(Long userId);

    User findByUserId(Long userId);

    Iterable<User> findAll();

    Page<User> findByUserName(String userName, PageRequest pageRequest);

    List<User> findByUserPhone(String userPhone);
}
