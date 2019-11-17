package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//매퍼 패키지가 생성될 때마다 여기에 추가.
@MapperScan(basePackages = "com.java.dogle.mapper.sample")
public class DogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogleApplication.class, args);
	}
}
