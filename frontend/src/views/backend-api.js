/* eslint-disable */
import axios from 'axios'

const AXIOS = axios.create({
  mode: 'no-cors',
  baseURL: 'http://localhost:9090',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'contentType': 'application/json'
  }
});

export default {
   /**
   * 로그인
   * @param {*} memberId 
   * @param {*} password
   */
  login(memberId, password) {
    return AXIOS.get('/member/memberLogin/' + memberId + '/' + password)
  },
  /**
   * 아이디중복확인
   * @param {*} memberId 
   */
  chkMemberIdDup(memberId) {
    return AXIOS.get('/member/memberInfo/id/' + memberId)
  },
  /**
   * 닉네임중복확인
   * @param {*} nickName 
   */
  chkNickNameDup(nickName) {
    return AXIOS.get('/member/memberInfo/nickName/' + nickName)
  },
   /**
   * 회원등록
   * @param {*} memberVO 
   */
  registMember(memberVO) {
    return AXIOS.post('/member/members', memberVO)
  }
}
