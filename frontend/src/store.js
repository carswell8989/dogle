import Vue from 'vue'
import Vuex from 'vuex'
import api from './views/backend-api'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    loginSucess: false,
    loginError: false,
    userId: null,
    userPass: null,
    accessToken: null
  },
  mutations: {
    login_success (state, payload) {
      state.loginSucess = true
      state.userId = payload.userId
      state.userPass = payload.userPass
      state.accessToken = payload.accessToken
    },
    login_error (state, payload) {
      state.loginError = true
      state.userId = payload.userId
    }
  },
  actions: {
    login ({
      commit
    }, memberVO) {
      return new Promise((resolve, reject) => {
        api.login(memberVO.memberId, memberVO.password)
          .then(response => {
            console.log('Response: ' + response.data + ' with Statuscode ' + response.status)
            // 인증 성공 시
            if (response.data === true) {
              const token = Math.random().toString(36).substring(2)
              localStorage.token = token
              console.log('Login successful', token)

              commit('login_success', {
                userId: memberVO.memberId,
                userPass: memberVO.password,
                accessToken: token
              })
            }
            // 인증 실패 시
            if (response.data === false) {
              reject(new Error('접근권한이없는 사용자이거나 아이디 및 비밀번호 오류'))
              commit('login_error', { userId: memberVO.memberId })
            }
            resolve(response)
          })
          .catch(error => {
            console.log('Error: ' + error)
          })
      })
    }
  },
  getters: {
    isLoggedIn: state => state.loginSuccess,
    hasLoginErrored: state => state.loginError,
    getUserId: state => state.userId,
    getUserPass: state => state.userPass,
    getAccessToken: state => state.accessToken
  }
})

export default store
