/* eslint-disable */
import axios from 'axios'

const AXIOS = axios.create({
 	method: 'GET',
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
		return AXIOS.get('http://localhost:9090/secured',{
			auth: {
				userId: id,
				password: password
            }
		})
	},
	chkNickNameDup(nickName) {
		return AXIOS.get('http://localhost:9090/chkNicknameDup', { 
			param: {
				nickName : nickName
			}
		})
	}
}