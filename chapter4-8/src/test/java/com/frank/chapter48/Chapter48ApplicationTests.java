package com.frank.chapter48;

import com.alibaba.fastjson.JSON;
import com.frank.chapter48.domain.User;
import com.frank.chapter48.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter48ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test_001(){
		// 插入一条数据
		userMapper.insert("AAA",20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20,u.getAge().intValue());

		// 更新数据
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30,u.getAge().intValue());

		// 删除数据
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		Assert.assertEquals(null,u);

		// Map插入数据
		Map<String,Object> map = new HashMap<>();
		map.put("name","CCC");
		map.put("age",23);
		userMapper.insertByMap(map);
		Assert.assertEquals(23,userMapper.findByName("CCC").getAge().intValue());

		List<User> userList = userMapper.findAll();
		System.out.println("userList => " + JSON.toJSONString(userList));

	}

}
