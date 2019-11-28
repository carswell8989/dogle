package com.java.dogle.dao.member;


import com.java.dogle.common.CommonDao;
import com.java.dogle.vo.member.MemberVO;

public class MemberDao extends CommonDao {
	public MemberDao() {
		this.nameSpace = "MemberDao";
	}
	

	/**
	 *
	 * 회원정보 조회 
	 *
	 * @param MemberVO
	 * @return MemberVO
	 * @throws Exception
	 *
	 */
	public MemberVO selectMemberDao001(MemberVO param) {
		return selectOne("selectMemberDao001", param);
	}
}
