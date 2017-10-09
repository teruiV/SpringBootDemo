package com.frank.chapter21;

import com.frank.chapter21.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter21ApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(Chapter21ApplicationTests.class);

	@Autowired
	private BlogService blogService;

	@Test
	public void test_001() {
		logger.info("name: " + blogService.getName());
		logger.info("title: " + blogService.getTitle());
		logger.info("desc: " + blogService.getDesc());
	}


}
