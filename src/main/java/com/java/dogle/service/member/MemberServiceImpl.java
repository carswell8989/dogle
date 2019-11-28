package com.java.dogle.service.member;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.dogle.dao.member.MemberDao;
import com.java.dogle.vo.member.MemberVO;

public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	public long chkNicknameDup(MemberVO param) {
		long chkFlag = 0;
		MemberVO result = memberDao.selectMemberDao001(param);
		
		if(result != null) chkFlag = 1;

		return chkFlag;
	}
}
