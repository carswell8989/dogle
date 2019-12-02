package com.java.dogle.vo.member;

import java.sql.Date;

import com.java.dogle.common.CommonVO;

/**
 * member VO
 * 
 * @author yujin.jeon
 * 
 */
public class MemberVO extends CommonVO {
	private static final long serialVersionUID = 1L;
	
	String memberId; // 회원아이디
	String password; // 비밀번호
	String nickName; // 닉네임
	String memberName; // 성명
	String birth; // 생년월일
	String cdv; // 우편번호
	String cv; // 주소
	String ccv; // 주소상세
	String mobileNumber; // 핸드폰번호
	String memberInfo; // 자기소개
	Date regDate; // 등록일
	char managerYn; // 관리자 여부
	char withdrawYn; // 탈퇴 여부
	String withdrawCode; // 탈퇴사유코드
	char personalInfoYn; // 개인정보동의 여부
	Date personalInfoRegDate; // 개인정보동의일자

	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCdv() {
		return cdv;
	}

	public void setCdv(String cdv) {
		this.cdv = cdv;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(String memberInfo) {
		this.memberInfo = memberInfo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public char getManagerYn() {
		return managerYn;
	}

	public void setManagerYn(char managerYn) {
		this.managerYn = managerYn;
	}

	public char getWithdrawYn() {
		return withdrawYn;
	}

	public void setWithdrawYn(char withdrawYn) {
		this.withdrawYn = withdrawYn;
	}

	public String getWithdrawCode() {
		return withdrawCode;
	}

	public void setWithdrawCode(String withdrawCode) {
		this.withdrawCode = withdrawCode;
	}

	public char getPersonalInfoYn() {
		return personalInfoYn;
	}

	public void setPersonalInfoYn(char personalInfoYn) {
		this.personalInfoYn = personalInfoYn;
	}

	public Date getPersonalInfoRegDate() {
		return personalInfoRegDate;
	}

	public void setPersonalInfoRegDate(Date personalInfoRegDate) {
		this.personalInfoRegDate = personalInfoRegDate;
	}

}
