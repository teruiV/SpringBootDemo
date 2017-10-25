package com.frank.chapter411;

import com.frank.chapter411.domain.User;
import com.frank.chapter411.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter411Application implements CommandLineRunner {
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("<<<<<< Elasticsearch 初始化数据开始 >>>>>>>");
		userService.save(new User(1L,"张三","18817394122"));
		userService.save(new User(2L,"李四","18817394132"));
		userService.save(new User(3L,"王二麻子","18817394142"));
		userService.save(new User(4L,"赵六子","18817394152"));
		System.out.println("<<<<<< Elasticsearch 初始化数据结束 >>>>>>>\n\n");
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter411Application.class, args);
	}
}
