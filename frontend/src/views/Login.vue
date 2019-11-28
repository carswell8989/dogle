<template>
  <div class="login">
    <h1>DOGLE</h1>
    <div class="unprotected" v-if="loginError">
      <h1>
        <p>You don't have rights here, mate :D</p>
      </h1>
      <h5>Seams that you don't have access rights...</h5>
    </div>
    <div class="unprotected" v-else>
      <h1>
        <p>Please login to get access!</p>
      </h1>
      <h5>You're not logged in - so you don't see much here. Try to log in:</h5>
      <form class="login-form" @submit.prevent="callLogin()">
        <el-input placeholder="아이디를 입력하세요" v-model="id" clearable class="user-input"></el-input>
        <el-input placeholder="비밀번호를 입력하세요" v-model="password" show-password class="user-input"></el-input>
        <button type="submit" class="btn-login">로그인</button>
        <el-button icon="el-icon-check" class="btn-join">
          <router-link to="/signup">회원가입</router-link>
        </el-button>
      </form>
    </div>
  </div>
</template>

<script>
import router from '../router'

export default {
  name: 'Login',
  data () {
    return {
      loginError: false,
      id: '',
      password: '',
      error: false,
      errors: []
    }
  },
  methods: {
    callLogin () {
      this.$store.dispatch('login',
        { id: this.id, password: this.password })
        .then(() => {
          router.push('/Protected')
        })
        .catch(error => {
          console.log('Error: ' + error)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.login {
  width: 30%;
  margin-left: 35%;
}
.login .login-form .user-input {
  margin: 5px 0;
}
.login .login-form .btn-login {
  width: 100%;
  margin-top: 20px;
}
.login .login-form .btn-join {
  float: right;
  margin-top: 5px;
}
</style>
