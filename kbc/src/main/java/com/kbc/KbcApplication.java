package com.kbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.kbc")
@EnableJpaRepositories("com.kbc.dao.jpa")
public class KbcApplication{

	private static final Logger log = LoggerFactory.getLogger(KbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KbcApplication.class, args);
	}

}
