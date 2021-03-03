package com.backend.gini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiniApplication.class, args);
	}

}
