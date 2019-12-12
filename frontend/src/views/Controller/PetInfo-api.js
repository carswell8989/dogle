import axios from 'axios'

const AXIOS = axios.create({
  mode: 'no-cors',
  baseURL: 'http://localhost:9090',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'contentType': 'application/json'
  }
})

export default {
  /**
     * 조회
     * @param {*} memberId
     */
  selectPetInfo (memberId) {
    return AXIOS.get('/petInfo/pets/' + memberId)
  }
}
