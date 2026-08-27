package com.innsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InnsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnsyncApplication.class, args);
		System.out.println("Hello from main");
	}

}
