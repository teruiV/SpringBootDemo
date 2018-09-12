package com.frank.chapter413;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.frank.chapter413")
@SpringBootApplication
@Slf4j
public class Chapter413Application{

	public static void main(String[] args) {
		SpringApplication.run(Chapter413Application.class, args);
	}

}
