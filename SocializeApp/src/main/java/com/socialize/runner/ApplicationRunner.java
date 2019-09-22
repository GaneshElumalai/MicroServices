package com.socialize.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.socialize"})
public class ApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}
}
