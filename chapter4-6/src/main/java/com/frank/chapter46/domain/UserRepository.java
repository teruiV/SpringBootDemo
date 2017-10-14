package com.frank.chapter46.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jianweilin on 2017/10/14.
 */
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
