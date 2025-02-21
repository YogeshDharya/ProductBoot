package com.example.MyDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example.MyDB.serviceImpl")
public class MyDbApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyDbApplication.class, args);
	}	
}
