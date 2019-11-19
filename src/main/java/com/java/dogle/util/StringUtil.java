package com.java.dogle.util;

import com.example.demo.DogleException;

/**
 * 
 * String 관련 유틸클래스
 *
 */



public class StringUtil {

	
	/**
	 * 
	 * NULL 또는 ""(빈 스트링)인 경우 true 리턴.
	 * 
	 */
	public static boolean isNull(String str) throws DogleException {
		
		boolean result = false;
		
		if(str == null || "".equals(str)) {
			result = true;
		}
		

		return result;
	}
	
	
	
	
	
}
