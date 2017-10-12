package com.frank.chapter43;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter43ApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp(){
		jdbcTemplate1.update("DELETE FROM USER ");
		jdbcTemplate2.update("DELETE FROM USER ");
	}

	@Test
	public void test() throws Exception {
		jdbcTemplate1.update("INSERT INTO user(name,age) values(?,?)","AA",23);
		jdbcTemplate1.update("INSERT INTO user(name,age) values(?,?)","BB",24);
		jdbcTemplate2.update("INSERT INTO user(name,age) values(?,?)","CC",25);
	}

}
