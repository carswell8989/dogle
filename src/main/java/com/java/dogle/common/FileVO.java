package com.java.dogle.common;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileVO extends CommonVO {

	private String fileDir; // 파일경로
	
	private String fileName; // 파일명(확장자포함)
	
	private String fileSize; //파일사이즈
 
	private File file; // 파일
	
	private MultipartFile mutilpartFile; //업로드 파일.
	
	
	
	public MultipartFile getMutilpartFile() {
		return mutilpartFile;
	}

	public void setMutilpartFile(MultipartFile mutilpartFile) {
		this.mutilpartFile = mutilpartFile;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
	
	
}
