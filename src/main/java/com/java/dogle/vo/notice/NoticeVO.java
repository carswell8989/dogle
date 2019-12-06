package com.java.dogle.vo.notice;

import java.util.List;

import com.java.dogle.common.PageVO;

public class NoticeVO extends PageVO {

	//공지사항번호
	private long noticeNo;
	//작성자 ID - 관리자 ID
	private String memberId;
	//제목
	private String title;
	//내용
	private String content;
	//최상단 노출여부
	private String topYn;
	//등록일
	private String regDate;
	//삭제여부
	private String delYn;
	//검색키워드 - 제목
	private String titleKeyword;
	
	private List<NoticeVO> list;
	
	

	public List<NoticeVO> getList() {
		return list;
	}

	public void setList(List<NoticeVO> list) {
		this.list = list;
	}

	public String getTitleKeyword() {
		return titleKeyword;
	}

	public void setTitleKeyword(String titleKeyword) {
		this.titleKeyword = titleKeyword;
	}

	public long getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(long noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopYn() {
		return topYn;
	}

	public void setTopYn(String topYn) {
		this.topYn = topYn;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
	
	
}
