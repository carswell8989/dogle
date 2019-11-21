<template>
  <div>
    <h1>
      <p>YEAH you made it!</p>
    </h1>
    <h5>If you're able to read this, you've successfully logged in and redirected to this protected site :)</h5>

    <el-button variant="primary" @click="getSecuredTextFromBackend()">Call the secured API</el-button>

    <div v-if="securedApiCallSuccess">
      <p variant="success">API call</p>
      Full response: {{ backendResponse }}
      <p variant="success">successful</p>
    </div>
    <div v-if="errors">
      <p>API call</p>
      {{ errors }}
      <p>NOT successful</p>
    </div>
  </div>
</template>

<script>
import api from './backend-api'
import store from './../store'

export default {
  name: 'Protected',

  data () {
    return {
      backendResponse: '',
      securedApiCallSuccess: false,
      errors: null
    }
  },
  methods: {
    getSecuredTextFromBackend () {
      api
        .getSecured(store.getters.getUserId, store.getters.getUserPass)
        .then(response => {
          console.log(
            'Response: ' + response.data + ' with Statuscode ' + response.status
          )
          this.securedApiCallSuccess = true
          this.backendResponse = response.data
        })
        .catch(error => {
          console.log('Error: ' + error)
          this.errors = error
        })
    }
  }
}
</script>
