<template>
  <div style="width:100%">
    <div class="brdList">
      <h1>공지사항</h1>
      <h2>공지사항 페이지입니다.</h2>
    </div>
    <el-table :data="noticeVO.list" border style="width:100%">
      <el-table-column prop="noticeNo" label="noticeNo"> </el-table-column>
      <el-table-column prop="title" label="title"> </el-table-column>
      <el-table-column prop="writer" label="writer"> </el-table-column>
      <el-table-column prop="regDate" label="regDate"> </el-table-column>
    </el-table>
        <el-pagination background layout="prev, pager, next" :total="100"></el-pagination>
 </div>
</template>
<script>
import api from '../Controller/Notice-api'
export default {
  name: 'NoticeIndex',
  data () {
    return {
      noticeVO: {
        titleKeyword: 'test',
        pageRow: 10,
        currentPage: 1,
        list: []
      }
    }
  }, // data
  methods: {
    // 공지사항 검색
    selectNoticeList () {
      api
        .noticeSelectList(this.noticeVO)
        .then(response => {
          console.log(response.data.result)
          this.noticeVO.list = response.data.result.list
        })
    }
  },
  /** 화면 로딩시 실행  */
  created: function () {
    this.selectNoticeList()
  }
}
/** 화면 로딩시 수행. */
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
