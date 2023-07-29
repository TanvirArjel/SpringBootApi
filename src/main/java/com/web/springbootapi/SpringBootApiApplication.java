package com.web.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.core.application"})
@ComponentScan({"com.core.domain"})
@EntityScan("com.core.domain")
@EnableJpaRepositories("com.core.domain.repositories")
public class SpringBootApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
}
