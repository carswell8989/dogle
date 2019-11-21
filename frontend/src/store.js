import Vue from 'vue'
import Vuex from 'vuex'
import api from './views/backend-api'

Vue.use(Vuex)

export default new Vuex.Store({
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
    login_Error (state, payload) {
      state.loginError = true
      state.userId = payload.userId
    }
  },
  actions: {
    login ({
      commit
    }, {
      id,
      password
    }) {
      return new Promise((resolve, reject) => {
        console.log('Accessing backend with user: ' + id)
        api.getSecured(id, password)
          .then(response => {
            console.log('Response: ' + response.data + ' with Statuscode ' + response.status)
            if (response.status === 200) {
              const token = Math.random().toString(36).substring(2)
              localStorage.token = token
              console.log('Login successful', token)
              // place the loginSuccess state into our vuex store
              commit('login_success', {
                userId: id,
                userPass: password,
                accessToken: token
              })
            }
            resolve(response)
          })
          .catch(error => {
            console.log('Error: ' + error)
            // place the loginError state into our vuex store
            commit('login_error', {
              userId: id
            })
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
