package com.java.dogle.mapper.sample;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SampleMapper {

	public int sample1();
	
}
