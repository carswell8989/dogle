<template>
  <div class="main">
    <h1>DOGLE</h1>
    <img src="../assets/logo.png" alt="doggle_logo" />
    <form class="login-form" @submit.prevent="login">
      <el-input placeholder="아이디를 입력하세요" v-model="id" clearable class="user-input"></el-input>
      <el-input placeholder="비밀번호를 입력하세요" v-model="password" show-password class="user-input"></el-input>
      <button type="submit" class="btn-login">로그인</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'MainIndex',
  data () {
    return {
      id: '',
      password: ''
    }
  },
  methods: {
    login () {
      if (this.id === 'test' && this.password === '1234') {
        console.log('인증성공!!!')
        // this.$router.replace(this.$route.query.redirect || '/')
      }
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
.main {
  width: 30%;
  margin-left: 35%;
}
.main .login-form .user-input {
  margin: 5px 0;
}
.main .login-form .btn-login {
  width: 100%;
  margin-top: 20px;
}
</style>
