package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.dogle.mapper.sample.SampleMapper;

/**
 * 
 * 각자의 패키지를 별도로 두되, 해당 컨트롤러를 메인으로 사용합니다.
 * 다른 패키지에 두는 경우 인식문제 발생.
 *
 */


@RestController
public class MainController {

	
	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
	
	@Autowired
	private SampleMapper sampleMapper;
	
//	@RequestMapping("/sample1")
//	public String sample1() {
//		
//		int result = sampleMapper.sample1();
//
//		LOGGER.info("sample1 ::: {}", result);
//
//		return "test";
//	}

	
	/** 호텔 검색*/
	@RequestMapping("/hotelSrh")
	public String hotelSrh() {
		
		int result = sampleMapper.sample1();

		LOGGER.info("hotelSrh ::: {}", result);

		return HELLO_TEXT;
	}
	
	
	/** 공지사항*/
	@RequestMapping("/board")
	public String board() {
		
		int result = sampleMapper.sample1();

		LOGGER.info("board ::: {}", result);

		return "board";
	}
	
	
	/** 마이페이지*/
	@RequestMapping("/myPage")
	public String mypage() {
		
		int result = sampleMapper.sample1();

		LOGGER.info("mypage ::: {}", result);

		return "mypage";
	}
	
}
