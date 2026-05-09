package com.assignment.intern_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.assignment.intern_assignment.repository")
public class InternAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternAssignmentApplication.class, args);
	}

}
