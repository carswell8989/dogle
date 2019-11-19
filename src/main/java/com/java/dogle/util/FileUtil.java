package com.java.dogle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.DogleException;
import com.java.dogle.common.FileVO;


 /**
  * 
  * 해당 클래스를 사용하기에 앞서, 파일은 src/main/resources 경로에 있어야 합니다.
  *
  *1. getFile() 파일을 읽어와서 리턴
  *2. readFileString() 특정 파일의 내용을 읽어서 리턴
  */




public class FileUtil {


	/**
	 * 
	 * @param FileVO
	 * @return FileVO
	 * @throws DogleException
	 * 
	 * 파일객체(파일 경로, 파일명)을 보내면, 파일을 찾아서 객체에 담아 리턴
	 */
	
	public static FileVO getFile(FileVO fileVo) throws DogleException {
		
		
		
		if(null == fileVo.getFileDir() || "".equals(fileVo.getFileDir())) {
			throw new DogleException("file directory is null");
		}
		
		if(null == fileVo.getFileName() || "".equals(fileVo.getFileName())) {
			throw new DogleException("file name is null");
		}
		
		
		
		
		//Resource resource = new ClassPathResource("files/temp/test.txt");
		Resource resource = new ClassPathResource(fileVo.getFileDir()+"/"+fileVo.getFileName());
		
		try {
			File file = resource.getFile();
			
			fileVo.setFile(file);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new DogleException(e.getMessage());
		}
		

		return fileVo;
	}
	
	/**
	 * 
	 * @param fileVo
	 * @return String
	 * @throws DogleException
	 * @throws IOException
	 * 
	 * 텍스트 파일인 경우, 해당 파일의 내용을 읽어서 리턴.
	 * 
	 */
	
	public static String readFileString(FileVO fileVo) throws DogleException, IOException {
		
		String str = "";
		
		if(null == fileVo.getFile()) {
			throw new DogleException("fileVo.getFile() is null");
		}
		
		 FileReader filereader = new FileReader(fileVo.getFile());
         //입력 버퍼 생성
         BufferedReader bufReader = new BufferedReader(filereader);
         StringBuffer buffer = new StringBuffer();
         String line;
         while((line = bufReader.readLine()) != null){
        	 buffer.append(line);
         }
         
         //.readLine()은 끝에 개행문자를 읽지 않는다.            
         bufReader.close();

         str = buffer.toString();
		
		return str;
	}
	
}
