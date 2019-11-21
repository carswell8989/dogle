package com.java.dogle.config;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix="file")
public class FileUploadProperties {
    //application.properties 의 file.upload-dir
	private String uploadDir;
 
    public String getUploadDir() {
        return uploadDir;
    }
 
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}