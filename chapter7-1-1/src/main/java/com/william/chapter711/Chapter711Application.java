package com.william.chapter711;

import com.william.chapter71.domain.Greeter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Chapter711Application implements CommandLineRunner{

	@Autowired
	private Greeter greeter;

	public static void main(String[] args) {
		SpringApplication.run(Chapter711Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("greeter info = {}", greeter.greet());
	}
}
