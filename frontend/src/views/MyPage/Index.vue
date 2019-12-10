<template>
  <div class="myPage">
    <h1>마이페이지</h1>
    <div></div>
    <el-row type="flex" class="row-bg" justify="space-around" >
      <el-col :span="23" class="grid-content bg-purple">
        <MyInfo></MyInfo>
      </el-col>
    </el-row>
    <el-row type="flex" class="row-bg" justify="space-around">
      <el-col :span="11" class="grid-content bg-purple">
        <PetInfo></PetInfo>
        <Reservation></Reservation>
      </el-col>
      <el-col :span="11"  class="grid-content bg-purple">
        <Favorite></Favorite>
        <Review></Review>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import MyInfo from './MyInformation/MyInfo'
import PetInfo from './MyPetInfo/PetInfo'
import Favorite from './MyFavorite/Favorite'
import Reservation from './MyReservation/Reservation'
import Review from './MyReview/Review'

export default {
  name: 'MyPageIndex',
  components: {
    MyInfo,
    PetInfo,
    Favorite,
    Reservation,
    Review
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
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom:  0px;
}
.bg-purple {
  background: #efefef;
}
</style>
