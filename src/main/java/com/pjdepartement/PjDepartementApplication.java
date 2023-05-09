package com.pjdepartement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pjdepartement.controller", "com.pjdepartement.entity", "com.pjdepartement.entity.repository", "com.pjdepartement.service", "com.pjdepartement.service.implement"})
public class PjDepartementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjDepartementApplication.class, args);
	}

}
