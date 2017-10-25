package com.frank.chapter410.service;

import com.frank.chapter410.domain.User;
import com.frank.chapter410.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jianweilin
 * @date 2017/10/24
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteByUserId(Long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByUserName(String userName, PageRequest pageRequest) {
        return userRepository.findByUserName(userName,pageRequest);
    }

    @Override
    public List<User> findByUserPhone(String userPhone) {
        return userRepository.findByUserPhone(userPhone);
    }
}
