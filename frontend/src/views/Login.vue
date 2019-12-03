<template>
  <div class="login">
    <h1>DOGLE</h1>
    <div class="unprotected" v-if="loginError">
      <p class="p-errorText"><i class=" el-icon-error"></i> 인증오류</p>
      <p class="p-errorText">권한이 없습니다. 로그인정보를 다시 확인해주세요 :(</p>
    </div>
    <div v-else>
      <p>서비스 이용 시 로그인이 필요합니다 :D </p>
    </div>
    <form class="login-form" @submit.prevent="callLogin()">
        <el-input placeholder="아이디를 입력하세요" v-model="memberVO.memberId" clearable class="user-input"></el-input>
        <el-input placeholder="비밀번호를 입력하세요" v-model="memberVO.password" show-password class="user-input"></el-input>
        <button type="submit" class="btn-login">로그인</button>
        <el-button icon="el-icon-position" class="btn-join">
          <router-link to="/signup">회원가입</router-link>
        </el-button>
      </form>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data () {
    return {
      loginError: false,
      memberVO: {
        memberId: '',
        password: ''
      },
      error: false,
      errors: []
    }
  },
  methods: {
    callLogin () {
      this.$store.dispatch('login', this.memberVO)
        .then(() => {
          this.$router.push('/Protected')
        })
        .catch(error => {
          this.loginError = true
          this.errors.push(error)
          this.error = true
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
.login .p-errorText {
  color: red;
  font-size: 16px;
}
</style>
