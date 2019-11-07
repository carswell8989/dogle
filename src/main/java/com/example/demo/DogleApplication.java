package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.java.dogle.sample")
public class DogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogleApplication.class, args);
	}

}
