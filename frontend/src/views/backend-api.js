/* eslint-disable */
import axios from 'axios'

const AXIOS = axios.create({
  mode: 'no-cors',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'contentType': 'application/json'
  }
});

export default {
  hello() {
    return AXIOS.get('http://localhost:9090/hotelSrh')
  },
  getSecured(id, password) {
    return AXIOS.get('http://localhost:9090/secured', {
      auth: {
        userId: id,
        password: password
      }
    })
  },
  /**
   * 닉네임 중복확인
   * @param {*} memberVO 
   */
  chkNickNameDup(memberVO) {
    return AXIOS.post('http://localhost:9090/chkNicknameDup', memberVO)
  },
   /**
   * 회원등록
   * @param {*} memberVO 
   */
  registMember(memberVO) {
    return AXIOS.post('http://localhost:9090/registMember', memberVO)
  }
}
