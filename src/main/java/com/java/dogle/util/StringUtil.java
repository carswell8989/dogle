package com.java.dogle.util;

import com.example.demo.DogleException;

/**
 * 
 * String 관련 유틸클래스
 *1. isNull() null 또는 빈스트링 체크
 */



public class StringUtil {

	
	/**
	 * 
	 * @param String
	 * @return boolean
	 * @throws DogleException
	 * 
	 * 파라미터 스트링이 null 또는 ""인 경우 true , 아니면 false리턴
	 */
	public static boolean isNull(String str) throws DogleException {
		
		boolean result = false;
		
		if(str == null || "".equals(str)) {
			result = true;
		}
		

		return result;
	}
	
	
	
	
	
}
