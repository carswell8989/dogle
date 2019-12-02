<template>
  <div>
    <div class="brdList">
      <h1>공지사항</h1>
      <h2>공지사항 페이지입니다.</h2>
    </div>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="date" label="Date" width="180"> </el-table-column>
      <el-table-column prop="name" label="Name" width="180"> </el-table-column>
      <el-table-column prop="address" label="Address"> </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="100"></el-pagination>
 </div>
</template>
<script>

export default {
  name: 'BoardIndex'
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
