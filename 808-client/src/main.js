import 'ant-design-vue/dist/reset.css'
import 'filepond/dist/filepond.min.css'
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css'
import 'vue3-toastify/dist/index.css'
import './assets/style.css'
import 'primevue/resources/themes/aura-light-green/theme.css'


import Vue3Toasity from 'vue3-toastify'
import { createApp } from 'vue'
import App from './App.vue'
import Antd from 'ant-design-vue'
import router from './router/index.js'
import PrimeVue from "primevue/config";

const app = createApp(App)
app.use(router)
app.use(Antd)
app.use(PrimeVue);
app.use(Vue3Toasity, {
  autoClose: 3000
})

app.mount('#app')
