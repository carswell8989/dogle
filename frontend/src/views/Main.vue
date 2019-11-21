<template>
  <div class="main">
    <h1>DOGLE</h1>
    <div v-if="isLoggedIn">
      <el-button type="primary">로그아웃</el-button>
    </div>
    <div v-if="!isLoggedIn">
      <el-button type="primary"><router-link to="/login">로그인</router-link></el-button>
    </div>
  </div>
</template>

<script>
import store from '../store'

export default {
  name: 'MainIndex',
  data () {
    return {
      isLoggedIn: store.state.loginSucess
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
.main .el-button a {color : #fff;}
</style>
