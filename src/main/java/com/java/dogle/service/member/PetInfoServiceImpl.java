package com.java.dogle.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dogle.dao.member.PetInfoDao;
import com.java.dogle.vo.member.MemberVO;
import com.java.dogle.vo.member.PetInfoVO;

/**
 * 
 * 애완견관리 ServiceImpl
 *
 * @author  전유진
 * @since   2019-12-10
 * @version 1.0
 * @see
 *
 * <pre>
 *
 * 개정이력(Modification Information)
 *
 * 수정일      		  수정자    수정내용
 * --------------------------------------------------
 * 2019-12-10    전유진    최초 생성
 * 
 * </pre>
 */
@Service
public class PetInfoServiceImpl implements PetInfoService {

	@Autowired
	PetInfoDao petInfoDao;
	
	
	/**
     * 조회
     *
     * @param  MemberVO
     * @return List<PetInfoVO>
     * @throws Exception
     *
     */
	@Override
	public List<PetInfoVO> selectPetInfo(MemberVO memberId) {
		
		List<PetInfoVO> result = petInfoDao.selectPetInfoDao001(memberId);
		
		return result;
	}

	
	/**
     * 등록
     *
     * @param  PetInfoVO
     * @return int
     * @throws Exception
     *
     */
	@Override
	public int registPetInfo(PetInfoVO param) {
		
		int result = petInfoDao.insertPetInfoDao002(param);
		
		return result;
	}

}
