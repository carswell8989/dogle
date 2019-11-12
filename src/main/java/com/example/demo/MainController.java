package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 각자의 패키지를 별도로 두되, 해당 컨트롤러를 메인으로 사용합니다.
 * 다른 패키지에 두는 경우 인식문제 발생.
 *
 */


@RestController
public class MainController {

	
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	
	
	
	
}
