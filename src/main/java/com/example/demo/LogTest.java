package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTest {

	//로그 필요시 아래 라인 복사해서 클래스를 변경한 뒤 사용해주세요.
	private static final Logger LOGGER = LogManager.getLogger(LogTest.class);
	
	@RequestMapping("/logTest")
	public void test() {
		LOGGER.info("test>>>>>");
	}
}
