package com.java.dogle.vo.member;

import com.java.dogle.common.CommonVO;

/**
 * PetInfoVO
 * 
 * @author yujin.jeon
 * 
 */
public class PetInfoVO extends CommonVO {
	
	private static final long serialVersionUID = 1L;
	
	// 애견 일련번호
	int petNo;
	// 회원 아이디
	String memberId;
	// 애견명
	String petName;
	// 나이
	int petAge;
	// 애견크기
	String petSizeKindCd;
	// 소개
	String petLike;
	
	
	public int getPetNo() {
		return petNo;
	}
	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	public String getPetSizeKindCd() {
		return petSizeKindCd;
	}
	public void setPetSizeKindCd(String petSizeKindCd) {
		this.petSizeKindCd = petSizeKindCd;
	}
	public String getPetLike() {
		return petLike;
	}
	public void setPetLike(String petLike) {
		this.petLike = petLike;
	}
	
	
}
