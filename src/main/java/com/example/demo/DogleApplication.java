package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.java.dogle.config.FileUploadProperties;


@SpringBootApplication
//@Service 어노테이션을 사용하는 패키지가 있는 경우 추가.
//@ComponentScan(basePackages = {"com.java.dogle.util", "com.java.dogle.controller"})


//매퍼 패키지가 생성될 때마다 여기에 추가.
@MapperScan(basePackages = "com.java.dogle.mapper.sample")



//application.properties에 접근하도록 설정.
/*
 * @EnableConfigurationProperties({ FileUploadProperties.class })
 */



public class DogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogleApplication.class, args);
	}
}
