package com.java.dogle.controller.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dogle.service.member.MemberService;
import com.java.dogle.vo.member.MemberVO;


@RestController
public class MemberController {

	private static final Logger LOGGER = LogManager.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping("/chkNicknameDup")
	public long chkNicknameDup(MemberVO param) {
		
		long result = memberService.chkNicknameDup(param);
		
		LOGGER.info("chkNicknameDup ::: {}", result);

		return result;
	}

}
