package com.frank.chapter52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Chapter52Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter52Application.class, args);
	}
}
