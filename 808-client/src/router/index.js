import { createRouter, createWebHistory } from 'vue-router'
/** Client Page */
import ClientHome from '../pages/client/client-home.vue'
import NotFound from '../pages/client/client-404.vue'
import ClientSignIn from '../pages/client/client-sign-in.vue'
import ClientSignUp from '../pages/client/client-sign-up.vue'
import Card from '../pages/client/client-sign-up.vue'

/** Admin Page */
import Admin from '../pages/admin/admin-dashboard.vue'
import ManagerCategory from '../pages/admin/category/admin-category-manager.vue' 
import CreateCategory from '../pages/admin/category/admin-category-create.vue' 
import UpdateCategory from '../pages/admin/category/admin-category-update.vue' 

const routes = [
  {
    path: '/',
    name: 'client-home',
    component: ClientHome
  },
  {
    path: '/:pathMatch(.*)*',
    component: NotFound
  },
  {
    path: '/sign-up',
    name: 'sign-up',
    component: ClientSignUp
  },
  {
    path: '/sign-in',
    name: 'sign-in',
    component: ClientSignIn
  },
  {
    path: '/admin',
    name: 'admin',
    component: Admin
  },
  {
    path: '/admin/createCategory',
    name: 'create-category',
    component: CreateCategory
  },
  {
    path: '/admin/updateCategory',
    name: 'update-category',
    component: UpdateCategory
  },
  {
    path: '/admin/manageCategory',
    name: 'manage-category',
    component: ManagerCategory
  },
  
  
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
