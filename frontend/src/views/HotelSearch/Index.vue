<template>
  <div class="hotelSrh">
    <h1>호텔검색</h1>
    <h2>반려견과 함께할 호텔을 검색해보세요!</h2>
  </div>
</template>

<script>

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
