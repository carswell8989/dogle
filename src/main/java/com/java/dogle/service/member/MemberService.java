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
     * 아이디중복확인
     *
     * @param  memberId
     * @return int
     * @throws Exception
     *
     */
	public int chkMemberIdDup(MemberVO memberId);
	
	
	/**
     * 닉네임중복확인
     *
     * @param  nickName
     * @return int
     * @throws Exception
     *
     */
	public int chkNickNameDup(MemberVO nickName);
	
	
	/**
     * 회원인증
     *
     * @param  MemberVO
     * @return int
     * @throws Exception
     *
     */
	public int login(MemberVO param);
	
	
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
