package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = "org.hov")
public class SnsMiddlewareApplication {
	public static void main(String[] args) {
		SpringApplication.run(SnsMiddlewareApplication.class, args);
	}
}
