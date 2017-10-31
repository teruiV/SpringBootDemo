package com.frank.chapter64;

import com.frank.chapter64.config.EmbedZookeeperServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter64Application {

	public static void main(String[] args) {
		EmbedZookeeperServer.start(6181);
		SpringApplication.run(Chapter64Application.class, args);
	}
}
