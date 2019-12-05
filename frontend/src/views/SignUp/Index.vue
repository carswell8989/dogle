<template>
  <div class="signUp">
    <h1>DOGLE</h1>

    <div class="sign-form">
      <ValidationObserver v-slot="{ handleSubmit }">
        <form @submit.prevent="handleSubmit(onSubmit)">
          <div>
            <el-row>
              <el-col :span="6" class="label">
                <label>아이디</label>
              </el-col>
              <el-col :span="18">
                 <ValidationProvider rules="required" v-slot="{ errors }">
                    <el-input placeholder="아이디를 입력하세요"  v-model="memberVO.memberId" name="아이디" clearable class="sign-input" @blur="chkMemeberIdDuplication()"></el-input>
                    <span class="error_msg">{{ errors[0] }}</span>
                    <span class="error_msg" v-if="memberVO.memberId !== ''"> {{ chkIdDupMsg }}</span>
                 </ValidationProvider>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" class="label">
                <label>비밀번호</label>
              </el-col>
              <el-col :span="16">
                   <ValidationProvider rules="required" v-slot="{ errors }">
                    <el-input placeholder="비밀번호를 입력하세요" v-model="memberVO.password" name="비밀번호" show-password class="sign-input"><i class ="el-icon-lock"></i></el-input>
                    <span class="error_msg">{{ errors[0] }}</span>
                   </ValidationProvider>
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
                <ValidationProvider rules="required" v-slot="{ errors }">
                  <el-input
                    placeholder="비밀번호를 입력하세요"
                    v-model="passwordChk"
                    show-password
                    class="sign-input"
                  ></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                </ValidationProvider>
              </el-col>
              <el-col :span="2">
                <el-button type="info" icon="el-icon-lock" circle></el-button>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" class="label">
                <label>닉네임</label>
              </el-col>
              <el-col :span="18">
                <ValidationProvider rules="required" v-slot="{ errors }">
                  <el-input placeholder="닉네임을 입력하세요" v-model="memberVO.nickName" clearable class="sign-input" @blur="chkNickNameDuplication()"></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                  <span class="error_msg" v-if="memberVO.nickName !== ''"> {{ chkNickNameDupMsg }}</span>
                </ValidationProvider>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" class="label">
                <label>휴대전화</label>
              </el-col>
              <el-col :span="18">
                <ValidationProvider rules="required|numeric" v-slot="{ errors }">
                  <el-input placeholder="전화번호을 입력하세요" v-model="memberVO.mobileNumber" clearable class="sign-input"></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                </ValidationProvider>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" class="label">
                <label>주소</label>
              </el-col>
              <el-col :span="5">
                <ValidationProvider rules="required" v-slot="{ errors }">
                  <el-input placeholder="지번" class="sign-input" v-model="memberVO.cdv"  :disabled="true"></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                </ValidationProvider>
              </el-col>
              <el-col :span="5">
                <el-button type="primary">주소찾기</el-button>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <ValidationProvider rules="required" v-slot="{ errors }">
                  <el-input placeholder="주소" class="sign-input" v-model="memberVO.cv"  :disabled="true"></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                </ValidationProvider>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <ValidationProvider rules="required" v-slot="{ errors }">
                  <el-input placeholder="상세주소" class="sign-input" v-model="memberVO.ccv"  :disabled="true"></el-input>
                  <span class="error_msg">{{ errors[0] }}</span>
                </ValidationProvider>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" class="label">
                <label>자기소개</label>
              </el-col>
              <el-col :span="18">
                <el-input type="textarea" :rows="2" placeholder="자기소개를 입력해주세요" v-model="memberVO.memberInfo"   maxlength="1000" show-word-limit></el-input>
              </el-col>
            </el-row>
          </div>
          <button type="submit">회원가입</button>
        </form>
      </ValidationObserver>
    </div>
  </div>
</template>

<script>
import api from '../backend-api'
import { ValidationProvider, ValidationObserver, extend } from 'vee-validate'
import { required, numeric, email } from 'vee-validate/dist/rules'

extend('required', {
  ...required,
  message: '* 필수값입니다.'
})
extend('numeric', {
  ...numeric,
  message: '유효한 값이 아닙니다.'
})
extend('email', email)

export default {
  name: 'SignUp',
  components: {
    ValidationProvider,
    ValidationObserver
  },
  data () {
    return {
      passwordChk: '',
      passwordChkFlag: false,
      completeChkIdDup: false,
      completeChkNickNameDup: false,
      chkIdDupMsg: '',
      chkNickNameDupMsg: '',
      memberVO: {
        memberId: '',
        password: '',
        nickName: '',
        memberName: '',
        birth: '',
        cdv: '',
        cv: '',
        ccv: '',
        mobileNumber: '',
        memberInfo: '',
        managerYn: 'N',
        personalInfoYn: 'N'
      },
      errors: []
    }
  },
  methods: {
    /**
     * 닉네임 중복확인
     */
    chkNickNameDuplication () {
      if (this.memberVO.nickName !== '') {
        api
          .chkMemberInfoDup({
            'nickName': this.memberVO.nickName})
          .then(response => {
            if (response.data === 0) {
              this.chkNickNameDupMsg = '사용가능한 닉네임입니다!'
              this.completeChkNickNameDup = true
            } else {
              this.chkNickNameDupMsg = '이미 사용 중입니다.'
              this.completeChkNickNameDup = false
            }
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    },
    /**
     * 아이디 중복확인
     */
    chkMemeberIdDuplication () {
      if (this.memberVO.memberId !== '') {
        api
          .chkMemberInfoDup({
            'memberId': this.memberVO.memberId
          })
          .then(response => {
            if (response.data === 0) {
              this.chkIdDupMsg = '사용가능한 아이디입니다!'
              this.completeChkIdDup = true
            } else {
              this.chkIdDupMsg = '이미 사용 중입니다.'
              this.completeChkIdDup = false
            }
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    },
    onSubmit () {
      alert('Form Submitted!')
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
.sign-form .error_msg {
  color: red;
  text-align: left;
  display: block;
  font-size: 12px;
  padding: 5px 0;
}
</style>
