package com.java.dogle.util;

import com.example.demo.DogleException;
import com.java.dogle.common.PageVO;

public class PagingUtil {


	/**
	 * @param PageVO
	 * @return void(파라미터 객체에 리턴)
	 * @throws DogleException
	 * 
	 * 객체를 보내면 해당 객체에 
	 * 총 페이지의 수
	 * 현재 페이지에서 보여줄 글의 offset을 담아서 리턴.
	 * 
	 */
	public static void setPageInfo(PageVO pageVo) throws DogleException {

		if(pageVo.getPageRow() <= 0) {
			throw new DogleException("PageRow가 없습니다.");
		}
		
		int totalPage = 0;  //전체 페이지
		int offset = 0; // 현재 페이지 기준 보여줄 글의 offset
		
		int total = pageVo.getTotal(); //글의 수 
		int pageRow = pageVo.getPageRow(); //페이지당 보여줄 글의 수
		int currentPage = pageVo.getCurrentPage(); // 현재 페이지 - 기본값 1
		pageVo.setLimit(pageRow);
		
		
		if(pageVo.getTotal() == 0) {
			return;
		}

		//기본값 1페이지로 설정.
		if(currentPage == 0) {
			currentPage = 1;
		}
		
		//전체 페이지
		totalPage = total / pageRow;
		
		//나누어 떨어지지 않는다면 1페이지가 더 필요.
		if(total % pageRow != 0) {
			totalPage++;
		}
		
		//현재 페이지가 총 페이지보다 큰 경우 -> 에러. - 1페이지로 셋팅.
		if(currentPage > totalPage) {
			currentPage = 1;
		}
				
		//시작 인덱스 = 페이지당 보여줄 글의 수 * (현재페이지 -1) + 1
		offset = pageRow * (currentPage-1) + 1;


		
		pageVo.setOffset(offset);
		pageVo.setTotalPage(totalPage);
		pageVo.setLimit(pageRow);
		
	}
	
	
	
	
	

	
}
