package com.java.dogle.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dogle.dao.member.MemberDao;
import com.java.dogle.vo.member.MemberVO;

/**
 * 
 * 회원가입 ServiceImpl
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
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	/**
     * 회원인증
     *
     * @param  MemberVO
     * @return int
     * @throws Exception
     *
     */
	@Override
	public int login(MemberVO param) {
		int result = memberDao.selectMemberDao001(param);
		
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
	@Override
	public int chkMemberIdDup(MemberVO memberId) {
		int result = memberDao.selectMemberDao001(memberId);

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
	@Override
	public int chkNickNameDup(MemberVO nickName) {
		int result = memberDao.selectMemberDao001(nickName);

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
	@Override
	public int registMember(MemberVO param) {
		int result = memberDao.insertMemberDao002(param);
		
		return result;
	}
}
