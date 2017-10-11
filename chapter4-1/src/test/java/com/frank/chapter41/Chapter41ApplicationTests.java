package com.frank.chapter41;

import com.frank.chapter41.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter41ApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(Chapter41ApplicationTests.class);
	@Autowired
    private UserService userService;

	@Before
    public void setUp(){
	    userService.deleteAllUsers();
    }

    @Test
    public void test_001(){
        userService.create("a",11);
        userService.create("b",21);
        userService.create("c",31);

        logger.info("user size => " + userService.getAllUsers());
        userService.deleteByName("a");
        logger.info("user size => " + userService.getAllUsers());
    }
}
