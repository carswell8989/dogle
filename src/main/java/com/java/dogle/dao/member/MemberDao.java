package com.java.dogle.dao.member;


import org.springframework.stereotype.Repository;

import com.java.dogle.common.CommonDao;
import com.java.dogle.vo.member.MemberVO;

@Repository
public class MemberDao extends CommonDao {
	public MemberDao() {
		this.nameSpace = "MemberMgmtDao";
	}
	

	/**
	 *
	 * 닉네임중복체크 
	 *
	 * @param MemberVO
	 * @return int
	 * @throws Exception
	 *
	 */
	public int selectMemberDao001(MemberVO param) {
		return selectOne("selectMemberDao001", param);
	}
	
	
	/**
	 *
	 * 회원정보 등록 
	 *
	 * @param MemberVO
	 * @return int
	 * @throws Exception
	 *
	 */
	public int insertMemberDao002(MemberVO param) {
		return insert("insertMemberDao002", param);		
	}
	
}
