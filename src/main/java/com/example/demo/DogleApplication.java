package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.java.dogle.config.FileUploadProperties;


@SpringBootApplication
//@Autowired 어노테이션으로 불러오는 객체들에 대한 패키지를 정의해야한다.
@ComponentScan(basePackages = {"com.java.dogle.config", "com.java.dogle.util", "com.java.dogle.controller", "com.java.dogle.dao"})


//매퍼 패키지가 생성될 때마다 여기에 추가.
//2019.11.21 -> 해당 어노테이션이 @ComponentScan 과 충돌함에 따라, mapper 인터페이스가 아닌 dao방식으로 변경.
//@MapperScan(basePackages = "com.java.dogle.mapper.sample")



//application.properties에 접근하도록 설정.

@EnableConfigurationProperties(
	{ FileUploadProperties.class }
)
 



public class DogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogleApplication.class, args);
	}
}
