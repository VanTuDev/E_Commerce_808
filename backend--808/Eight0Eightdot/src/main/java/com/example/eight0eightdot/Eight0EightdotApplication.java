package com.example.eight0eightdot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Eight0EightdotApplication {

	public static void main(String[] args) {
		SpringApplication.run(Eight0EightdotApplication.class, args);
	}

}
