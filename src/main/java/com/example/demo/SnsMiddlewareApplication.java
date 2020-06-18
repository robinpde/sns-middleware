package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.hov")
public class SnsMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsMiddlewareApplication.class, args);
	}

}
