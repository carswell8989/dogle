<template>
  <div class="main">
    <h1>Dogle</h1>
    <h2>Dogle - Main Page</h2>
    <ul>
      <li>
        <a href="./" target="_blank">홈</a>
      </li>
      <li>
        <a href="/hotelSrh" target="_blank">호텔검색</a>
      </li>
      <li>
        <a href="/board" target="_blank">공지사항</a>
      </li>
      <li>
        <a href target="_blank">로그아웃</a>
      </li>
      <li>
        <a href="/myPage" target="_blank">마이페이지</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'MainIndex'
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
</style>
