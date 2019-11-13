package com.java.dogle.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * 단방향 암호화 SHA256 util 클래스
 *
 */

public class SHA256Util {

	public String encrpty (String planeText) {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
}
