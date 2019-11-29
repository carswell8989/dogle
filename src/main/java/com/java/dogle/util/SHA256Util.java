package com.java.dogle.util;

import java.security.MessageDigest;
import com.example.demo.DogleException;

/**
 * 
 * 단방향 암호화 SHA256 util 클래스
 *
 */

public class SHA256Util {
	
	/**
	 * 
	 * @param planeText
	 * @return
	 * @throws DogleException
	 * 평문 String을 매개변수로 보내면, SHA256으로 암호화된 String을 리턴합니다.
	 */
	

	public static String encrypt (String planeText) throws DogleException {
		
		String result="";
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(planeText.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
			
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
			result = hexString.toString();
            
		} catch (Exception e) {
			new DogleException(e.getMessage());
		}
		
		return result;
		
	}
	
	
}
