import Vue from 'vue'
import Router from 'vue-router'
import MainIndex from '@/views/Main'
import HotelIndex from '@/views/HotelSearch/Index'
import BoardIndex from '@/views/Board/Index'
import MyPageIndex from '@/views/MyPage/Index'

Vue.use(Router)

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
      component: HotelIndex
    },
    {
      path: '/board',
      name: 'BoardIndex',
      component: BoardIndex
    },
    {
      path: '/myPage',
      name: 'MyPageIndex',
      component: MyPageIndex
    }
  ]
})
