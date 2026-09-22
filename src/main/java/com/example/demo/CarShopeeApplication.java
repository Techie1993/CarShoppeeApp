package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.example.demo",
	    "com.example.sellers",
	    "com.example.cars",
	    "com.example.garage",
	    "com.example.contacts",
	    "com.example.chats",
	    "com.example.service",
	    "com.example.payments"
	})

@EnableJpaRepositories(basePackages = {
	    "com.example.demo",
	    "com.example.sellers",
	    "com.example.cars",
	    "com.example.garage",
	    "com.example.contacts",
	    "com.example.chats",
	    "com.example.service",
	    "com.example.payments"
	    
	})

@EntityScan(basePackages = {
	    "com.example.demo",
	    "com.example.sellers",
	    "com.example.cars",
	    "com.example.garage",
	    "com.example.contacts",
	    "com.example.chats",
	    "com.example.service",
	    "com.example.payments"
	})

public class CarShopeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShopeeApplication.class, args);
	}

}
