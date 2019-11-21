package com.java.dogle.controller;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DogleException;
import com.java.dogle.common.FileVO;
import com.java.dogle.dao.SampleDao;
import com.java.dogle.util.FileUtil;

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
	
	/*
	 * @Autowired private SampleMapper sampleMapper;
	 */
	
	@Autowired
	private SampleDao sampleDao;
	
	//@Autowired
	//private FileUtil fileUtil;
	
	
	@RequestMapping("/sample1")
	public String sample1() {
		
		//인터페이스 방식
		//int result = sampleMapper.sample1();

		//dao 방식
		int result = sampleDao.sample1();
		
		
		LOGGER.info("sample1 ::: {}", result);

		return "test";
	}

	
	/** 호텔 검색*/
	@CrossOrigin(origins="http://localhost:9091")  // --크로스도메인 문제를 해결하기위해 프론트엔드 주소를 입력한다.
	@RequestMapping("/hotelSrh")
	public String hotelSrh() {
		
	

		return HELLO_TEXT;
	}
	
	
	/** 공지사항*/
	@CrossOrigin(origins="http://localhost:9091")  // --크로스도메인 문제를 해결하기위해 프론트엔드 주소를 입력한다.
	@RequestMapping("/board")
	public String board() {
		
	

		return "board";
	}
	
	
	/** 마이페이지*/
	@CrossOrigin(origins="http://localhost:9091")  // --크로스도메인 문제를 해결하기위해 프론트엔드 주소를 입력한다.
	@RequestMapping("/myPage")
	public String mypage() {


		return "mypage";
	}
	
	
	
	@RequestMapping("/fileTest")
	public String fileTest() throws DogleException, IOException {
		
		FileVO fileVo = new FileVO();
		//src/main/resource/ 부터 경로지정.
		fileVo.setFileDir("files/temp");
		fileVo.setFileName("test.txt");
		
		//파일 가져오는 유틸
		//FileVO result = fileUtil.getFile(fileVo);
		
		//파일 읽는 유틸(텍스트인 경우)
		//String test = fileUtil.readFileString(result);

		//upload에 파일저장.
		//fileUtil.saveFileLocal(result);
		
		return "temp";
		
	}
	
	
}
