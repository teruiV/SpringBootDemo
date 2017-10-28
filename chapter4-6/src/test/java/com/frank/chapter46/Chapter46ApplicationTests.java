package com.frank.chapter46;

import com.frank.chapter46.domain.User;
import com.frank.chapter46.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter46ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp(){
		userRepository.deleteAll();
	}
	

	@Test
	public void test_001(){
		// 创建三个User,并验证User总数
		userRepository.save(new User(1L,"张三",30));
		userRepository.save(new User(2L,"王武",40));
		userRepository.save(new User(3L,"招商",50));
		Assert.assertEquals(3,userRepository.findAll().size());
	}
}
