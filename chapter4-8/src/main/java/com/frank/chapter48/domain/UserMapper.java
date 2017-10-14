package com.frank.chapter48.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jianweilin on 2017/10/14.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user where name= #{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    @Select("SELECT name,age from user")
    List<User> findAll();

    @Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
    int insert(@Param("name")String name,@Param("age") Integer age);

    @Update("UPDATE user set age = #{age} where name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user where id = #{id}")
    void delete(Long id);

    @Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
    int insertByMap(Map<String,Object> map);



}
