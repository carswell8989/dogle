package com.java.dogle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.example.demo.DogleException;
import com.java.dogle.common.FileVO;
import com.java.dogle.config.FileUploadProperties;


 /**
  * 
  * 해당 클래스를 사용하기에 앞서, 파일은 src/main/resources 경로에 있어야 합니다.
  *
  *1. getFile() 파일을 읽어와서 리턴
  *2. readFileString() 특정 파일의 내용을 읽어서 리턴
  */



@Service("fileUtil")
public class FileUtil {
	
	 private static Path fileLocation;
	
	
	  @Autowired public FileUtil(FileUploadProperties prop) throws DogleException {
	  
	  fileLocation = Paths.get(prop.getUploadDir())
	  .toAbsolutePath().normalize();
	  
	  try { Files.createDirectories(fileLocation); }catch(Exception e) { throw
	  new DogleException(e.getMessage()); } }
	 



	/**
	 * 
	 * @param FileVO
	 * @return FileVO
	 * @throws DogleException
	 * 
	 *  파일객체(파일 경로, 파일명)을 보내면, 파일을 찾아서 객체에 담아 리턴
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
	
	/**
	 * 
	 * @param fileVo
	 * @return String
	 * @throws DogleException
	 * @throws IOException
	 * 
	 * File 객체를 전송하면, 파일명을 생성하여
	 * src/main/resources/files/upload 에 업로드 하고 
	 * 해당 파일명을 리턴한다.
	 * 
	 */
	
	
	public static String saveFileLocal(FileVO fileVo) throws DogleException, IOException {
		
		/**
		 * //저장경로 C:/project/dogle/src/main/resources/files/upload
		 */
		
		String fileName = fileVo.getFileName();
		int extensionIndex = fileName.indexOf(".");
		String extension = fileName.substring(extensionIndex);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
		Date date = new Date();
		
		String newFileName = sdf.format(date);
		
		newFileName = newFileName + extension;
		
		
		//만든 파일명으로 해당 파일을 저장.
	
		Path targetLocation = fileLocation.resolve(newFileName);
		//일반파일
		Files.copy(new FileInputStream(fileVo.getFile()), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        //multipart
		//Files.copy(fileVo.getMutilpartFile().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		
		return newFileName;
	}
	
	
	/**
	 * 
	 * @param fileVo
	 * @return String
	 * @throws DogleException
	 * @throws IOException
	 * 
	 * MultipartFile 객체를 전송하면, 파일명을 생성하여
	 * src/main/resources/files/upload 에 업로드 하고 
	 * 해당 파일명을 리턴한다.
	 * 
	 */
	
	
     public static String saveMultiPartFileLocal(FileVO fileVo) throws DogleException, IOException {
		
		/**
		 * //저장경로 C:/project/dogle/src/main/resources/files/upload
		 */
		
		String fileName = fileVo.getFileName();
		int extensionIndex = fileName.indexOf(".");
		String extension = fileName.substring(extensionIndex);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
		Date date = new Date();
		
		String newFileName = sdf.format(date);
		
		newFileName = newFileName + extension;
		
		
		//만든 파일명으로 해당 파일을 저장.
	
		Path targetLocation = fileLocation.resolve(newFileName);
		//일반파일
		//Files.copy(new FileInputStream(fileVo.getFile()), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        //multipart
		Files.copy(fileVo.getMutilpartFile().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		
		return newFileName;
	}
	
}
