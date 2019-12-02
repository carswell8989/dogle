package com.java.dogle.controller.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DogleException;
import com.java.dogle.service.member.MemberService;
import com.java.dogle.util.SHA256Util;
import com.java.dogle.vo.member.MemberVO;

/**
 * 
 * 회원가입 Controller
 *
 * @author  전유진
 * @since   2019-12-02
 * @version 1.0
 * @see
 *
 * <pre>
 *
 * 개정이력(Modification Information)
 *
 * 수정일      		  수정자    수정내용
 * --------------------------------------------------
 * 2019-12-02    전유진    최초 생성
 * 
 * </pre>
 */
@RestController
public class MemberController {

	private static final Logger LOGGER = LogManager.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	
	/**
     * 닉네임 중복확인
     *
     * @param  MemberVO
     * @return int
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/chkNicknameDup")
	public int chkNicknameDup(@RequestBody MemberVO param) {

		int result = memberService.chkNicknameDup(param);
		
		LOGGER.info("chkNicknameDup ::: {}", result);

		return result;
	}

	
	/**
     * 회원등록
     *
     * @param  MemberVO
     * @return N/A
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/registMember")
	public int registMember(@RequestBody MemberVO param) {
		MemberVO memberInfo = param;
		
		// 비밀번호 암호화
		try {
			memberInfo.setPassword(SHA256Util.encrypt(param.getPassword()));
		} catch (DogleException e) {
			e.printStackTrace();
		}
		
		int result = memberService.registMember(memberInfo);
		
		LOGGER.info("registMember ::: {}", result);

		return result;
	}
}
