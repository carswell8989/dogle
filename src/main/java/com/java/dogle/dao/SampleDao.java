package com.java.dogle.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {

	private final String  NAMESPACE = "SampleDao.";
	
	@Autowired
	private SqlSession sqlSession;

	public int sample1(){
		return sqlSession.selectOne(NAMESPACE + "sample1");
	}
	
	
	
}
