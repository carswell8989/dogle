/* eslint-disable */
import axios from 'axios'

export default {
	hello() {
		  return axios('http://localhost:9090/hotelSrh', {
			method: 'GET',
			mode: 'no-cors',
			headers: {
				'Access-Control-Allow-Origin': '*',
				'Content-Type': 'application/json'
			}
		})
	}
}