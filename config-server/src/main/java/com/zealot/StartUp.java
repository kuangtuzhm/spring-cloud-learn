package com.zealot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class StartUp {

	public static void main(String[] args) {
		
		SpringApplication.run(StartUp.class, args);
	}

}
