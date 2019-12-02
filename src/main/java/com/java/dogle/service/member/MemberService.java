package com.java.dogle.service.member;

import com.java.dogle.vo.member.MemberVO;

/**
 * 
 * 회원가입 Service
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
public interface MemberService {
	
	/**
     * 닉네임 중복확인
     *
     * @param  MemberVO
     * @return int
     * @throws Exception
     *
     */
	public int chkNicknameDup(MemberVO param);
	
	
	/**
     * 회원등록
     *
     * @param  MemberVO
     * @return N/A
     * @throws Exception
     *
     */
	public int registMember(MemberVO param);
}
