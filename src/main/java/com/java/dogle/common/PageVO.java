package com.java.dogle.common;



/**
 * 
 * 페이지 관련 객체 이용시 해당 VO를 extends 해주시기 바랍니다.
 *
 */

public class PageVO extends CommonVO {
	
	private int pageRow; //한 페이지당 보여줄 글의 수
 
	private int total; //전체 글의 수
	
	private int currentPage; //현재 페이지
	
	private int offset; //쿼리에서 사용할 offset (현재 페이지에서 보여줄 글의 인덱스)
	
	private int totalPage; //마지막 페이지

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	
	
	
	
	
	
	
}
