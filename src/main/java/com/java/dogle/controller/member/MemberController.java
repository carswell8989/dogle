package com.java.dogle.controller.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/member")
public class MemberController {

	private static final Logger LOGGER = LogManager.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	/**
     * 회원인증
     *
     * @param  MemberVO
     * @return N/A
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/memberLogin/{memberId}/{password}")
	public boolean memberLogin(@PathVariable String memberId, @PathVariable String password) {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		try {
			memberVO.setPassword(SHA256Util.encrypt(password));
		} catch (DogleException e) {
			e.printStackTrace();
		}
		
		boolean result = (memberService.login(memberVO) == 1) ? true : false;
		
		LOGGER.info("memberLogin ::: {}", result);

		return result;
	}
	
	
	
	/**
     * 아이디중복확인
     *
     * @param  memberId
     * @return int
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/memberInfo/id/{memberId}")
	public boolean chkMemberIdDup(@PathVariable String memberId) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		
		boolean result = (memberService.chkMemberIdDup(memberVO) > 0) ? true : false;
		
		LOGGER.info("chkMemberIdDup ::: {}", result);

		return result;
	}

	
	
	/**
     * 닉네임중복확인
     *
     * @param  memberId
     * @return int
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/memberInfo/nickName/{nickName}")
	public boolean chkNickNameDup(@PathVariable String nickName) {

		MemberVO memberVO = new MemberVO();
		memberVO.setNickName(nickName);
		
		boolean result = (memberService.chkNickNameDup(memberVO) > 0) ? true : false;
		
		LOGGER.info("chkNickNameDup ::: {}", result);

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
	@RequestMapping("/members")
	public int registMember(@RequestBody MemberVO param) {
		
		MemberVO memberInfo = param;		
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
