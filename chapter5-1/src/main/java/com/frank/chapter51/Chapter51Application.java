package com.frank.chapter51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Chapter51Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter51Application.class, args);
	}
}
