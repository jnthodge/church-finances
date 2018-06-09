package com.he.giving.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.he.giving" })
public class RestfulLogTestApp {
	
	public static void main(String args[]) {
		SpringApplication.run(RestfulLogTestApp.class, args);
	}
}
