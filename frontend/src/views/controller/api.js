import axios from 'axios'

export default {
  hello () {
    return axios('/hotelSrh', {
      method: 'GET',
      mode: 'no-cors',
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
      },
      withCredentials: true,
      credentials: 'same-origin'
    })
  }
}
