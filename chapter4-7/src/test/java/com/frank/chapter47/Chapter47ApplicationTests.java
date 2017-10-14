package com.frank.chapter47;

import com.frank.chapter47.domain.User;
import com.frank.chapter47.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter47ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
//	@Rollback
	public void test_001(){
		userMapper.insert("AAA",20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20,u.getAge().intValue());
	}

	@Test
	public void test_002(){
		userMapper.update("BBBB",1);
	}

	@Test
	public void test_003(){
		userMapper.deleteById(1);
	}

}
