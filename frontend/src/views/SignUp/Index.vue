<template>
  <form class="signUp">
    <h1>DOGLE</h1>

    <div class="sign-form">
      <el-row>
        <el-col :span="6" class="label">
          <label>아이디</label>
        </el-col>
        <el-col :span="18">
          <el-input placeholder="아이디를 입력하세요" v-model="id" clearable class="sign-input"></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>비밀번호</label>
        </el-col>
        <el-col :span="16">
          <el-input placeholder="비밀번호를 입력하세요" v-model="password" show-password class="sign-input"></el-input>
        </el-col>
        <el-col :span="2">
          <el-button type="info" icon="el-icon-lock" circle></el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>비밀번호 재확인</label>
        </el-col>
        <el-col :span="16">
          <el-input
            placeholder="비밀번호를 입력하세요"
            v-model="passwordChk"
            show-password
            class="sign-input"
          ></el-input>
        </el-col>
        <el-col :span="2">
          <el-button type="info" icon="el-icon-lock" circle></el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>닉네임</label>
        </el-col>
        <el-col :span="14">
          <el-input placeholder="닉네임을 입력하세요" v-model="nickname" clearable class="sign-input"></el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary">중복확인</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>휴대전화</label>
        </el-col>
        <el-col :span="13">
          <el-input placeholder="전화번호을 입력하세요" v-model="phoneNum" clearable class="sign-input"></el-input>
        </el-col>
        <el-col :span="5">
          <el-button type="primary">인증번호 받기</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-input
            placeholder="인증번호을 입력하세요"
            v-model="code"
            class="sign-input"
            aria-readonly="true"
          ></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>주소</label>
        </el-col>
        <el-col :span="5">
          <el-input placeholder="지번" class="sign-input" aria-readonly="true"></el-input>
        </el-col>
        <el-col :span="5">
          <el-button type="primary">주소찾기</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-input placeholder="주소" class="sign-input" aria-readonly="true"></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-input placeholder="상세주소" class="sign-input"></el-input>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6" class="label">
          <label>자기소개</label>
        </el-col>
        <el-col :span="18">
          <el-input type="textarea" :rows="2" placeholder="자기소개를 입력해주세요" v-model="textarea"></el-input>
        </el-col>
      </el-row>
    </div>
    <button type="submit">회원가입</button>
  </form>
</template>

<script>
export default {
  name: 'SignUp',
  data () {
    return {
      id: '',
      password: '',
      passwordChk: '',
      nickname: '',
      phoneNum: '',
      textarea: ''
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
.sign-form {
  width: 40%;
  margin: 0 30%;
}
.sign-form .el-row {
  padding: 5px 0;
}
.sign-form .label {
  font-size: 12px;
  line-height: 30px;
  text-align: left;
}
.sign-form .sign-input .el-input__inner {
  height: 30px;
}
</style>
