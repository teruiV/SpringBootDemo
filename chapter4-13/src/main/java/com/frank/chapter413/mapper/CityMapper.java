package com.frank.chapter413.mapper;

import com.frank.chapter413.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/9/12
 */
public interface CityMapper {
    @Select("SELECT city_name, country, state FROM city")
    @Results({@Result(property = "cityName", column = "city_name")})
    List<City> getAll();

    @Select("SELECT * FROM city where id = #{id}")
    @Results({@Result(property = "cityName", column = "city_name"),
            @Result(property = "country", column = "country")})
    City getOne(Long id);

    @Insert("INSERT INTO city(city_name,state,country) VALUES(#{cityName}, #{state}, #{country})")
    void insert(City city);

    @Update("UPDATE city set city_name=${cityName} where id #{id}")
    void update(City city);

    @Delete("DELETE FROM city where id = #{id}")
    void delete(Long id);
}
