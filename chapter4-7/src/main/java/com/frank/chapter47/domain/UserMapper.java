package com.frank.chapter47.domain;

import org.apache.ibatis.annotations.*;

/**
 * Created by jianweilin on 2017/10/14.
 */
@Mapper
public interface UserMapper {
    @Select("Select * FROM User where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
    Integer insert(@Param("name")String name,@Param("age") Integer age);

    @Update("UPDATE user set name=#{name} WHERE id=#{id}")
    Integer update(@Param("name")String name,@Param("id") Integer id);

    @Delete("delete from user where id=#{id}")
    Integer deleteById(@Param("id")Integer id);

}
