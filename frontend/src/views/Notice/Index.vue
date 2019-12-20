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
   <paginate v-model="noticeVO.currentPage" :page-count="pageCount" :page-range="3" :margin-pages="2" :click-handler="clickCallback" :prev-text="'Prev'" :next-text="'Next'" :container-class="'pagination'" :page-class="'page-item'"></paginate>
 </div>
</template>
<script>
import api from '../Controller/Notice-api'
import Paginate from 'vuejs-paginate'
import Vue from 'vue'
Vue.component('paginate', Paginate)
export default {
  name: 'NoticeIndex',
  data () {
    return {
      noticeVO: {
        titleKeyword: 'test',
        pageRow: 10,
        currentPage: 1,
        list: [],
        total: 100,
        totalPage: 10
      },
      pageCount: 10
    }
  }, // data
  methods: {
    // 공지사항 검색
    selectNoticeList () {
      api
        .noticeSelectList(this.noticeVO)
        .then(response => {
          console.log(response.data.result)
          this.noticeVO = response.data.result
          if (this.noticeVO.totalPage < this.pageCount) {
            this.pageCount = this.noticeVO.totalPage
          }
        })
    },
    clickCallback (num) {
      console.log('num ? :' + num)
      this.noticeVO.currentPage = num
      this.selectNoticeList()
    }
  },
  /** 화면 로딩시 실행  */
  created: function () {
    this.selectNoticeList()
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
</style>
