package com.huru.runner.application;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan("com.huru")
@EntityScan("com.huru.entity")
@EnableJpaRepositories("com.huru.repos")
public class RunnnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnnerApplication.class, args);
	}

}


