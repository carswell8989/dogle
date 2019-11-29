package com.java.dogle.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dogle.dao.member.MemberDao;
import com.java.dogle.vo.member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDao;
	
	@Override
	public int chkNicknameDup(MemberVO param) {
		int cnt = memberDao.selectMemberDao001(param);

		return cnt;
	}
}
