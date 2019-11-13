package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dogle.mapper.sample.SampleMapper;

@RestController
public class SampleController {

	
	private static final Logger LOGGER = LogManager.getLogger(SampleController.class);
	
	@Deprecated
	private SampleMapper sampleMapper;
	
	@Deprecated
	public String sample1() {
		
		int result = sampleMapper.sample1();

		LOGGER.info("sample1 ::: {}", result);
		
		
		return "test";
	}
}


