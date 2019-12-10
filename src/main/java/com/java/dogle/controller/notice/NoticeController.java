package com.java.dogle.controller.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DogleException;
import com.java.dogle.service.notice.NoticeService;
import com.java.dogle.util.SHA256Util;
import com.java.dogle.vo.notice.NoticeVO;

@RestController
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	/**
     * 공지사항 selectList
     *
     * @param  MemberVO
     * @return N/A
     * @throws Exception
     *
     */
	@CrossOrigin("*") 
	@RequestMapping("/notice/selectList")
	public Map<String, Object> selectNoticeA(@RequestBody NoticeVO param) throws DogleException {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", noticeService.selectNoticeA(param));
		
		return resultMap;
	
	}
	
	
}
