package com.apps.register.server;
import org.springframework.cloud.netflix.eureka.server.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaServer
public class RegistrationService{
	public static void main(String[] args) {
		SpringApplication.run(RegistrationService.class, args);
	}
}
