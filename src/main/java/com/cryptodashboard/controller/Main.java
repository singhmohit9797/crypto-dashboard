package com.cryptodashboard.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cryptodashboard.controller", "com.cryptodashboard.model", "com.cryptodashboard.service"})
public class Main {
	
	public static void main(String[] args)
	{
		SpringApplication.run(Main.class, args);
	}

}
