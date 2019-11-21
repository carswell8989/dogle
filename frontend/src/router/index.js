import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'
import MainIndex from '@/views/Main'
import HotelIndex from '@/views/HotelSearch/Index'
import BoardIndex from '@/views/Board/Index'
import MyPageIndex from '@/views/MyPage/Index'
import Login from '@/views/Login'
import Protected from '@/views/Protected'

Vue.use(Router)

const requireAuth = () => (to, from, next) => {
  if (store.getters.getAccessToken !== null) {
    return next()
  }
  next('/login')
}

export default new Router({
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
      beforeEnter: requireAuth()
    },
    {
      path: '/board',
      name: 'BoardIndex',
      component: BoardIndex,
      beforeEnter: requireAuth()
    },
    {
      path: '/myPage',
      name: 'MyPageIndex',
      component: MyPageIndex,
      beforeEnter: requireAuth()
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/protected',
      name: 'Protected',
      component: Protected
    }
  ]
})
