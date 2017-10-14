package com.frank.chapter49.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jianweilin on 2017/10/14.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);

    User findByNameAndAge(String name,Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
