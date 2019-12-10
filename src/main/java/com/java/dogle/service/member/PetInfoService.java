package com.java.dogle.service.member;

import java.util.List;

import com.java.dogle.vo.member.MemberVO;
import com.java.dogle.vo.member.PetInfoVO;

/**
 * 
 * 애완견관리 Service
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
public interface PetInfoService {

	/**
     * 조회
     *
     * @param  MemberVO
     * @return List<PetInfoVO>
     * @throws Exception
     *
     */
	List<PetInfoVO> selectPetInfo(MemberVO memberId);
	
	
	/**
     * 등록
     *
     * @param  PetInfoVO
     * @return int
     * @throws Exception
     *
     */
	int registPetInfo(PetInfoVO param);
}
