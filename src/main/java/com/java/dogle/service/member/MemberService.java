package com.java.dogle.service.member;

import com.java.dogle.vo.member.MemberVO;

public interface MemberService {
	public long chkNicknameDup(MemberVO param);
}