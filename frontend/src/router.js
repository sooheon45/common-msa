
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import StoreStoreManager from "./components/listers/StoreStoreCards"
import StoreStoreDetail from "./components/listers/StoreStoreDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/stores/stores',
                name: 'StoreStoreManager',
                component: StoreStoreManager
            },
            {
                path: '/stores/stores/:id',
                name: 'StoreStoreDetail',
                component: StoreStoreDetail
            },



    ]
})
