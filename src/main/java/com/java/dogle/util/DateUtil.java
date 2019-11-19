package com.java.dogle.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.example.demo.DogleException;

/**
 * 
 * 
 * Date 관련 유틸 클래스.
 * 
 * 
 */

public class DateUtil {

	
	/**
	 * 
	 * Date 타입을 yyyyMMdd 형식으로 리턴.
	 * 
	 */
	

	public static String getFormatyyyyMMdd(Date date) throws DogleException {
		
		String result="";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		result = sdf.format(date);

		return result;
		
	}
	
	/**
	 * 
	 * Date 타입을 yyyy-MM-dd 형식으로 리턴.
	 * 
	 */
	
	
	public static String getFormatyyyyMMdd2(Date date) throws DogleException {
		
		String result="";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		result = sdf.format(date);

		return result;
		
	}
	
	/**
	 * 
	 * 두 날짜(String)의 차이를 구해서 일수로 리턴.
	 * @throws DogleException 
	 * @Param yyyyMMdd 또는 yyyy-MM-dd
	 */
	
	public static int getDiffDate(String date1, String date2) throws DogleException {
		
		int diff = 0;
		
		// yyyy-MM-dd인 경우 하이픈 제거.
		if(date1.indexOf('-') > 0) {
			date1.replaceAll("-", "");
		}
		if(date2.indexOf('-') > 0) {
			date2.replaceAll("-", "");
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date parseDate1 = sdf.parse(date1);
			Date parseDate2 = sdf.parse(date2);
			
			long diffInMillies = Math.abs(parseDate2.getTime() - parseDate1.getTime());
		    // diffInMillies / 1000 / 60 / 60 / 24
			long diff2 = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    
		    diff = (int)diff2;
		    
		} catch (ParseException e) {
			e.printStackTrace();
			throw new DogleException(e.getMessage());
		}
		

		return diff;
	}
	
	
}
