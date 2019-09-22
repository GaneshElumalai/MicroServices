package user.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"user"})
@EnableJpaRepositories(basePackages = {"user.repo"})
@EntityScan(basePackages = {"user.entity"})
@EnableEurekaClient
public class ApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}
}
