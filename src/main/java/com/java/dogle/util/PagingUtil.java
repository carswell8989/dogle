package com.java.dogle.util;

import com.example.demo.DogleException;
import com.java.dogle.common.PageVO;

public class PagingUtil {

	
	
	/**
	 * 특정 게시판의 검색조건에 맞는 페이지의 수 계산.
	 * @param pageRow - 한 페이지에 보여주는 글의 수
	 * @param total - 검색조건에 맞는 게시글의 총 갯수
	 * @return - 화면에 보여줄 페이지의 수.
	 * @throws DogleException
	 */
	
	public static int pageCounter(int pageRow, int total) throws DogleException {
		
		int totalPage = 0;
		
		totalPage = total / pageRow;
		
		//나누어 떨어지지 않는다면 1페이지가 더 필요.
		if(total % pageRow != 0) {
			totalPage++;
		}
				
		return totalPage;
		
	}
	
	/**
	 * 
	 * 현재 페이지에서 보여줘야 할 offset -> 이를 쿼리에서 활용.
	 * @param pageRow 한 페이지당 보여줄 글의 수
	 * @param currentPage 현재 페이지
	 * @param total 총 글의 수
	 * @return
	 * @throws DogleException
	 */
	public static int calculateOffset(int pageRow, int currentPage, int total) throws DogleException {
		
		int offset = 0;
		
		int totalPage = PagingUtil.pageCounter(pageRow, total);		
		
		//현재 페이지가 총 페이지보다 큰 경우 -> 에러.
		if(currentPage > totalPage) {
			return -1;
		}
		
		//시작 인덱스 = 페이지당 보여줄 글의 수 * (현재페이지 -1) + 1
		offset = pageRow * (currentPage-1) + 1;
		

		return offset;
	}
	
	
	/**
	 * 
	 * 위의 메서드를 이용하여, 객체를 보내면 해당 객체에 셋팅해줌.
	 * 
	 */
	public static void countPage(PageVO pageVo) throws DogleException {
		
		if(pageVo.getPageRow() <= 0) {
			throw new DogleException("PageRow가 없습니다.");
		}
		
		if(pageVo.getCurrentPage() <= 0) {
			throw new DogleException("현재 페이지 정보가 없습니다.");
		}
		
		if(pageVo.getTotal() <= 0) {
			throw new DogleException("작성된 글이 없습니다.");
		}
		
		int offset = PagingUtil.calculateOffset(pageVo.getPageRow(), pageVo.getCurrentPage(), pageVo.getTotal());
		
		pageVo.setOffset(offset);
			
		
	}
	
}
