package com.java.dogle.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DogleException;
import com.java.dogle.dao.notice.NoticeDao;
import com.java.dogle.util.PagingUtil;
import com.java.dogle.vo.notice.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	
	@Autowired
	private NoticeDao noticeDao;
	
	/**
	 * @param NoticeVO
	 * @return List
	 * 
	 * 공지사항 list를 반환한다.
	 */
	
	@Override
	public NoticeVO selectNoticeA(NoticeVO param) throws DogleException {

		/**
		 * 메인 Vo에는 pageing 정보
		 * 하위 list에는 글 리스트 반환.
		 */
		
		//조건에 맞는 count select
		NoticeVO resultVo = noticeDao.selectNoticeA();
		
		//없으면 그냥 리턴.
		if(resultVo.getTotal() == 0) {
			return resultVo;
		}
		
		//pageRow 설정
		resultVo.setPageRow(10);
		
		//객체에 페이징 정보 셋팅 함수 호출.
		PagingUtil.setPageInfo(resultVo);
		
		//조건에 맞는 count select
		resultVo.setList(noticeDao.selectNoticeB(resultVo));
		
		return resultVo;
	}

	
	
	
}
