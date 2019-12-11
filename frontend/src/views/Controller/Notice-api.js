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
   * 검색 
   * @param {*} titleKeyword 
   * 
   */
  noticeSelectList(titleKeyword) {
    return AXIOS.get('/noticeSelectList/' + titleKeyword)
  },

}
