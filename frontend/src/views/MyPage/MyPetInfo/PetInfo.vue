<template>
  <div class="petInfo">
    <h3>나의 애완견 정보</h3>

    <el-table
    :data="selectPetInfo().filter(data => !search || data.petName.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label="petName"
      prop="petName">
    </el-table-column>
      <el-table-column
      label="petAge"
      prop="petAge">
    </el-table-column>
      <el-table-column
      label="petLike"
      prop="petLike">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="Type to search"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
import api from '../../Controller/PetInfo-api'
import memberStore from '../../Store/memberStore'

export default {
  name: 'MyPetInfo',
  data () {
    return {
      memberId: '',
      petInfoList: [],
      search: ''
    }
  },
  created () {
  },
  methods: {
    selectPetInfo () {
      this.memberId = memberStore.getters.getUserId
      api.selectPetInfo(this.memberId)
        .then(response => {
          if (response.data !== null) {
            this.petInfoList = response.data
          }
        })
        .catch(e => {
          this.errors.push(e)
        })

      return this.petInfoList
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
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
</style>
