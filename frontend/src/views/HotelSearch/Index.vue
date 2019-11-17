<template>
  <div class="hotelSrh">
    <h1>호텔검색</h1>
    <h2>반려견과 함께할 호텔을 검색해보세요!</h2>

    <button @click="getData()">데이터 가져오기</button>

    <p v-if="showResponse">{{data}}</p>
  </div>
</template>

<script>
import api from '../controller/api'

export default {
  name: 'HotelIndex',
  data () {
    return {
      response: [],
      errors: [],
      data: '',
      showResponse: false
    }
  },
  methods: {
    // Fetches posts when the component is created.
    getData () {
      api
        .hello()
        .then(response => {
          this.response = response.data
          this.data = response.data
          console.log('Success! ' + response.data)
          this.showResponse = true
        })
        .catch(e => {
          this.errors.push(e)
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
</style>
