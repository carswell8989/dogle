package com.java.dogle.dao.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.DogleException;
import com.java.dogle.common.CommonDao;
import com.java.dogle.vo.notice.NoticeVO;

@Repository
public class NoticeDao extends CommonDao {

	public NoticeDao() {
		this.nameSpace = "noticeDao";
	}
	
	
	public NoticeVO selectNoticeA() throws DogleException {
		return selectOne("selectNoticeCount1");	
	}
	
	public List<NoticeVO> selectNoticeB(NoticeVO param) throws DogleException {
		return selectList("selectNoticeList1", param);
	}
	
	public List<NoticeVO> selectNoticeC(NoticeVO param) throws DogleException {
		return selectList("selectNoticeList2", param);
	}
	
	
}
