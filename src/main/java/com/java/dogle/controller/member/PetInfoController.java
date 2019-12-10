package com.java.dogle.controller.member;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DogleException;
import com.java.dogle.service.member.PetInfoService;
import com.java.dogle.util.SHA256Util;
import com.java.dogle.vo.member.MemberVO;
import com.java.dogle.vo.member.PetInfoVO;

/**
 * 
 * 애완견관리 Controller
 *
 * @author  전유진
 * @since   2019-12-10
 * @version 1.0
 * @see
 *
 * <pre>
 *
 * 개정이력(Modification Information)
 *
 * 수정일      		  수정자    수정내용
 * --------------------------------------------------
 * 2019-12-10    전유진    최초 생성
 * 
 * </pre>
 */
@RestController
@RequestMapping("/petInfo")
public class PetInfoController {
	
	private static final Logger LOGGER = LogManager.getLogger(PetInfoController.class);
	
	@Autowired
	PetInfoService petInfoService;
	
	
	/**
     * 조회
     *
     * @param  MemberVO
     * @return List<PetInfoVO>
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/pets/{memberId}")
	public List<PetInfoVO> selectPetInfo(@PathVariable String memberId) {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		
		List<PetInfoVO> result = petInfoService.selectPetInfo(memberVO);
		
		LOGGER.info("selectPetInfo ::: {}", result);

		return result;
	}
	
	
	/**
     * 등록
     *
     * @param  List<PetInfoVO>
     * @return boolean
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/pets")
	public boolean registPetInfo(@RequestBody List<PetInfoVO> petInfoVOList) throws Exception {

		boolean result = false;
		
		for(PetInfoVO petInfoVO:petInfoVOList) {
			petInfoVO.setPetNo(System.identityHashCode(System.nanoTime()));
			result =  (petInfoService.registPetInfo(petInfoVO) == 1) ? true : false;
		}
		
		LOGGER.info("registPetInfo ::: {}", result);
		
		return result;		
	}
}
