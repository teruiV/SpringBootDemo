package com.frank.chapter31;

import com.frank.chapter31.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter31ApplicationTests {

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void test_001() throws Exception {
		// 测试UserController
		RequestBuilder request = null;

		request = post("/")
				.param("id","1")
				.param("name","测试大师")
				.param("age","11");
		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("add success")));
	}

}
