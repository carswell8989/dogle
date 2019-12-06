package com.java.dogle.service.notice;

import java.util.List;

import com.example.demo.DogleException;
import com.java.dogle.vo.notice.NoticeVO;

public interface NoticeService {

	public NoticeVO selectNoticeA(NoticeVO param) throws DogleException;
	
	
}
