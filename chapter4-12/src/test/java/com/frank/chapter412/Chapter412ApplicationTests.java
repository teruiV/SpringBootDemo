package com.frank.chapter412;

import com.frank.chapter412.entity.test.tables.records.UserRecord;
import com.frank.chapter412.repository.test.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter412ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test_001(){
		UserRecord userRecord = new UserRecord();
		userRecord.setName("张三");
		userRecord.setAge(23);
		userRepository.AddUser(userRecord);
		System.out.println("新增用户成功！");
	}

}
