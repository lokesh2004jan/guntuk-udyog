package com.example.guntuk.udyog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.guntuk.udyog.model")
public class GuntukUdyogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuntukUdyogApplication.class, args);
	}

}
