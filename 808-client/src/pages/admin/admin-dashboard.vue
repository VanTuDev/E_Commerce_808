<template>
  <header>
    <div class="px-4 py-2 border">
      <router-link :to="{ name: 'client-home' }" class="text-[0.9em] text-ellipsis">
        <p class="text-black font-bold text-5xl inline">808</p>
        <p class="text-blue-400 text-3xl inline font-bold">.</p>
      </router-link>
    </div>
    <div class=""></div>
  </header>
  <main class="">
    <div class="flex select-none ">
      <div
        class="side-bar w-[17%] min-h-[800px] px-4 py-5 border border-l border-r border-b border-solid "
      >
        <div class="my-3 rounded-lg" @click="handleButton('homePageButton')">
        <div class="flex px-3 py-3" :class="{ 'bg-sky-200 text-sky-600 rounded-t-md': homePageButton }">
          <img
            :src="productIcon"
            alt="Product Icon"
            class="mr-2 w-[10%]"
            :class="{ 'my-svg': homePageButton }"
          />
          <p class="text-lg font-semibold">Thống kê</p>
        </div>
        <div
          class="menu w-full invisible opacity:0; transition:visibility 0.3s linear,opacity 0.3s linear;"
          v-if="homePageButton"
          :class="{ 'bg-sky-100 text-sky-600 rounded-b-md': homePageButton }"
        >
          <ul class="list-disc py-2 px-2">
            <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-sky-200 rounded-md">
              Thuộc tính
            </li>
            <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-sky-200 rounded-md">Hãng</li>
            <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-sky-200 rounded-md">
              Nhà cung cấp
            </li>
          </ul>
        </div>
        </div>
        <div class="my-3 rounded-lg" @click="handleButton('productButton')">
          <div class="flex px-3 py-3" :class="{ 'bg-red-100 text-red-600 rounded-t-lg': productButton }">
            <img
              :src="productIcon"
              alt="Product Icon"
              class="mr-2 w-[10%]"
              :class="{ 'my-svg': productButton }"
            />
            <p class="text-lg font-semibold">Sản phẩm </p>
          </div>
          <div
            class="menu w-full invisible opacity:0; transition:visibility 0.3s linear,opacity 0.3s linear;"
            v-if="productButton"
            :class="{ 'bg-red-50 text-red-500 rounded-b-md': productButton }"
          >
            <ul class="list-disc py-2 px-2">
              <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-red-100 rounded-md" @click="handleChildButton('categoryButton')">
                Loại
             </li>
              <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-red-100 rounded-md">
                Thuộc tính
              </li>
              <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-red-100 rounded-md">Hãng</li>
              <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-red-100 rounded-md">
                Nhà cung cấp
              </li>
              <li class="px-3 py-2 font-semibold text-md list-inside hover:bg-red-100 rounded-md">
                Đơn vị
              </li>
            </ul>
          </div>
        </div>
        <div class="my-3 rounded-lg" @click="handleButton('orderButton')">
            <div class="flex px-3 py-3" :class="{ 'bg-pink-200 text-pink-600 rounded-t-lg': orderButton }">
              <img
                :src="productIcon"
                alt="Product Icon"
                class="mr-2 w-[10%]"
                :class="{ 'my-svg': orderButton }"
              />
              <p class="text-lg font-semibold">Đặt hàng </p>
            </div>
            <div
              class="menu w-full invisible opacity:0; transition:visibility 0.3s linear,opacity 0.3s linear;"
              v-if="orderButton"
              :class="{ 'bg-pink-100 text-pink-600 rounded-b-lg': orderButton }"
            >
              <ul class="list-disc py-2 px-2">
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-pink-200 rounded-lg">
                  Nguồn đơn hàng
                </li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-pink-200 rounded-lg">
                  Lí do huỷ đơn hàng
                </li>
              </ul>
            </div>
        </div>
        <div class="my-3 rounded-lg" @click="handleButton('userButton')">
            <div class="flex px-3 py-3" :class="{ 'bg-violet-200 text-violet-600 rounded-t-lg': userButton }">
              <img
                :src="productIcon"
                alt="Product Icon"
                class="mr-2 w-[10%]"
                :class="{ 'my-svg': userButton }"
              />
              <p class="text-lg font-semibold">Người dùng </p>
            </div>
            <div
              class="menu w-full invisible opacity:0; transition:visibility 0.3s linear,opacity 0.3s linear;"
              v-if="userButton"
              :class="{ 'bg-violet-100 text-violet-600 rounded-b-lg': userButton }"
            >
              <ul class="list-disc py-2 px-2">
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-violet-200 rounded-lg">Loại</li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-violet-200 rounded-lg">
                  Thuộc tính
                </li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-violet-200 rounded-lg">Hãng</li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-violet-200 rounded-lg">
                  Nhà cung cấp
                </li>
              </ul>
            </div>
        </div>
        <div class="my-3 rounded-lg" @click="handleButton('wareHouse')">
            <div class="flex px-3 py-3" :class="{ 'bg-orange-200 text-orange-600 rounded-t-lg': wareHouse }">
              <img
                :src="productIcon"
                alt="Product Icon"
                class="mr-2 w-[10%]"
                :class="{ 'my-svg': wareHouse }"
              />
              <p class="text-lg font-semibold">Kho đồ </p>
            </div>
            <div
              class="menu w-full invisible opacity:0; transition:visibility 0.3s linear,opacity 0.3s linear;"
              v-if="wareHouse"
              :class="{ 'bg-orange-100 text-orange-600 rounded-b-lg': wareHouse }"
            >
              <ul class="list-disc py-2 px-2">
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-orange-200 rounded-lg">Loại</li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-orange-200 rounded-lg">
                  Thuộc tính
                </li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-orange-200 rounded-lg">Hãng</li>
                <li class="px-3 py-2 font-semibold text-lg list-inside hover:bg-orange-200 rounded-lg">
                  Nhà cung cấp
                </li>
              </ul>
            </div>
        </div>
      </div>
      <div class="mr-2 w-full">
        <div v-if="categoryButton" class="">
            
            <CategoryManager></CategoryManager>
        </div>
      </div>
    </div>
  </main>
  <button @click="showSomeThing">show edit</button>
</template>
<script>
import CategoryManager from './category/admin-category-manager.vue'
export default {
    components: {
        CategoryManager,

    },
    data() {
        return {
        productButton:    false,
            categoryButton:     false,
        homePageButton:   false,
        orderButton:      false,
        userButton:       false,
        wareHouse:        false,
        productIcon: '../../src/assets/icon/product-icon.svg'
        }
    },
    methods: {
        handleButton(button) {
        if (button === 'productButton') {
            this.productButton = !this.productButton;
        } else if (button === 'homePageButton') {
            this.homePageButton = !this.homePageButton;
        } else if (button === 'orderButton') {
            this.orderButton = !this.orderButton;
        } else if (button === 'userButton') {
            this.userButton = !this.userButton;
        } else if (button === 'wareHouse') {
            this.wareHouse = !this.wareHouse;
        }
    },
        handleChildButton(button){
        console.log("aur lick")
        if(button === 'categoryButton') this.categoryButton = !this.categoryButton
    }
  
  }
}
</script>
<style scoped>
body{
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.menu {
  visibility: visible;
  opacity: 1;
}
.my-svg {
  fill: rgba(97, 218, 251, 1);
}
</style>
