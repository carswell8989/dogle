package com.java.dogle.dao;

import org.springframework.stereotype.Repository;
import com.java.dogle.common.CommonDao;

@Repository
public class SampleDao extends CommonDao {
	
	//네임스페이스만 지정 xml
	public SampleDao() {
		this.nameSpace = "SampleDao";
	}
	

	/*
	 * private final String NAMESPACE = "SampleDao.";
	 * 
	 * @Autowired private SqlSession sqlSession;
	 * 
	 * public int sample1(){ return sqlSession.selectOne(NAMESPACE + "sample1"); }
	 */
	
	//공통 dao 상속 처리 방식으로 사용.
	public int sample1() {
		return selectOne("sample1");
	}
	
	
}
