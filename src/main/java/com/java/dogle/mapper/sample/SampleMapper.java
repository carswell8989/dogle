package com.java.dogle.mapper.sample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("sampleMapper")
public interface SampleMapper {

	public int sample1();
	
}
