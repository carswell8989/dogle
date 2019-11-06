package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTest {

	
	private static final Logger LOGGER = LogManager.getLogger(LogTest.class);
	
	@RequestMapping("/logTest")
	public void test() {
		LOGGER.info("test>>>>>");
	}
}
