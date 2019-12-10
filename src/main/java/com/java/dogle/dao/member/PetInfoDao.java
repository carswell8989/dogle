package com.java.dogle.dao.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.dogle.common.CommonDao;
import com.java.dogle.vo.member.MemberVO;
import com.java.dogle.vo.member.PetInfoVO;

/**
*
* PetInfoDao
*
* @author  전유진
* @since   2019. 12. 10
* @version 1.0
* @see
*
* <pre>
*
* 개정이력(Modification Information)
*
* 수정일          		수정자    수정내용
* --------------------------------------------------
* 2019.12.10  	전유진    최초 생성
* 
* </pre>
*/
@Repository
public class PetInfoDao extends CommonDao {
	public PetInfoDao() {
		this.nameSpace = "PetInfoDao";
	}

	
	/**
	 *
	 * 조회 
	 *
	 * @param  MemberVO
	 * @return List<PetInfoVO>
	 * @throws Exception
	 *
	 */
	public List<PetInfoVO> selectPetInfoDao001(MemberVO param) {
		return selectList("selectPetInfoDao001", param);
	}
	
	
	/**
	 *
	 * 등록 
	 *
	 * @param  PetInfoVO
	 * @return int
	 * @throws Exception
	 *
	 */
	public int insertPetInfoDao002(PetInfoVO param) {
		return insert("insertPetInfoDao002", param);
	}
}
