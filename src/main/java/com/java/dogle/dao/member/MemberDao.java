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
	 * 회원정보 조회 
	 *
	 * @param MemberVO
	 * @return MemberVO
	 * @throws Exception
	 *
	 */
	public int selectMemberDao001(MemberVO param) {
		return selectOne("selectMemberDao001", param);
	}
}
