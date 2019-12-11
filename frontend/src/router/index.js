import Vue from 'vue'
import Router from 'vue-router'
import store from '@/views/Store/memberStore'
import MainIndex from '@/views/Main'
import HotelIndex from '@/views/HotelSearch/Index'
import NoticeIndex from '@/views/Notice/Index'
import MyPageIndex from '@/views/MyPage/Index'
import Login from '@/views/Login'
import Protected from '@/views/Protected'
import SignUp from '@/views/SignUp/Index'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'MainIndex',
      component: MainIndex
    },
    {
      path: '/hotelSrh',
      name: 'HotelIndex',
      component: HotelIndex,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/notice',
      name: 'NoticeIndex',
      component: NoticeIndex,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/member/myPage',
      name: 'MyPageIndex',
      component: MyPageIndex,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/member/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/protected',
      name: 'Protected',
      component: Protected,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/member/SignUp',
      name: 'SignUp',
      component: SignUp,
      children: [

      ]
    },
    // otherwise redirect to home
    { path: '*', redirect: '/' }
  ]
})

// beforeEach()의 콜백 함수에 사용자 인증 여부를 체크하는 로직을 추가
router.beforeEach(function (to, from, next) {
  // to : 이동할 url
  // from : 현재 url
  // next : to에서 지정한 url로 이동하기 위해 꼭 호출해야 하는 함수
  if (to.matched.some(function (routeInfo) {
    return routeInfo.meta.requiresAuth
  })) {
    if (store.getters.getAccessToken !== null) {
      return next()
    } else {
      next('/login')
    }
  } else {
    next()
  }
})

export default router
