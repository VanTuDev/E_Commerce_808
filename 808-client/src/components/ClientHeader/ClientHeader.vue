<template>
    <div class="first-part flex justify-between items-center ">
          <div class="header-logo">
            <div class="flex justify-start items-end">
              <router-link :to="{name: 'client-home'}" class="text-[0.9em] text-ellipsis">
                <p class="text-black font-bold text-4xl inline">{{logoText}}</p>
                <p class="text-blue-400 text-3xl inline font-bold">.</p>
              </router-link>
            </div>
          </div>
          <div :class="searchBarClass">
            <div class="relative">
              <span class="absolute inset-y-0 left-0 pl-3 flex items-center">
                <img :src="searchIcon" alt="" class="h-5 w-5 text-gray-400">
              </span>
              <input 
                class="w-full rounded-md px-10 py-2 bg-custom-bg text-gray-900 border-none focus:border-blue-500 transition duration-300 ease-in-out"
                id="username" 
                type="text" 
                autocomplete="off"
                placeholder="Bạn tìm gì ..." 
              >
            </div>                    
          </div>
          <div class="flex justify-center items-center mt-2">
            <div class="px-2 py-2 rounded-lg bg-custom-bg mr-1">
              <img :src="cartIcon" alt="">
            </div>
            <div class="px-2 py-2 rounded-lg bg-custom-bg mr-1" >
              <img :src="ringIcon" alt="">
            </div>   
            <div class="relative px-2 py-2 rounded-lg bg-custom-bg mr-1" @click="onOpen" >
              <img :src="avatarIcon" alt="">
              <ClientMenu v-if="buttonStatus" @cancel="onClose"></ClientMenu>
            </div> 
          </div>     
    </div>    
    
  </template>
  
  <script>
    import ClientMenu from './ClientMenu.vue'
  export default {
    
    components:{
      ClientMenu
    },
    props: {
      logoText: {
        type: String,
        required: true
      },
      searchBarClass: {
        type: String,
        default: 'md:w-96 xl:w-96 2xl:w-header-search-bar-custom'
      },
      searchIcon: {
        type: String,
        default: './src/assets/icon/search-icon.svg',
      },
      cartIcon: {
        type: String,
        default: './src/assets/icon/cart-icon.svg'
      },
      ringIcon: {
        type: String,
        default: './src/assets/icon/ring-icon.svg'
      },
      avatarIcon: {
        type: String,
        default: './src/assets/icon/avatar-icon.svg'
      }
    },
    data(){
      return {
        buttonStatus: false
      }
    },
    methods: {
            onOpen(){
                this.buttonStatus = !this.buttonStatus
            }
        }
  }
  </script>
  