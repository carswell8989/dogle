<template>
  <div id="app">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo dogle-nav"
      mode="horizontal"
      @select="handleSelect"
    >
      <el-menu-item index="1">
        <router-link to="/">홈</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/hotelSrh">호텔검색</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/notice">공지사항</router-link>
      </el-menu-item>
      <el-menu-item  index="4">
        <router-link to="/member/myPage">마이페이지</router-link>
      </el-menu-item >
    </el-menu>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      activeIndex: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#app a {
  display: inline-block;
  text-decoration: none;
  width: 100px;
  font-size: 12px;
}
#app .dogle-nav .btn-login {
  float: right;
}

#app .dogle-nav .btn-login a {color: #fff; display: inline-block;}
</style>
