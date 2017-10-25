package com.frank.chapter410;

import com.frank.chapter410.domain.User;
import com.frank.chapter410.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter410Application implements CommandLineRunner {


	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("<<<<<< Elasticsearch 参数配置开始 >>>>>>>");
//		Map<String,String> parameters = elasticsearchOperations.getClient().settings().getAsMap();
//		parameters.entrySet().forEach(entry -> {
//			System.out.println(entry.getKey() + " = " + entry.getValue());
//		});
//		System.out.println(">>>>>> Elasticsearch 参数配置结束 <<<<<<<<\n\n");

		System.out.println("<<<<<< Elasticsearch 初始化数据开始 >>>>>>>");
		userService.save(new User(1L,"张三","18817394122"));
		userService.save(new User(2L,"李四","18817394132"));
		userService.save(new User(3L,"王二麻子","18817394142"));
		userService.save(new User(4L,"赵六子","18817394152"));
		System.out.println("<<<<<< Elasticsearch 初始化数据结束 >>>>>>>\n\n");
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter410Application.class, args);
	}


}
