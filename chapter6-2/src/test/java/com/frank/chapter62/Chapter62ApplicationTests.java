package com.frank.chapter62;

import com.frank.chapter62.rabbit.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter62ApplicationTests {

	@Autowired
	private Sender sender;
	@Test
	public void test_001(){
		sender.send();
	}
}
