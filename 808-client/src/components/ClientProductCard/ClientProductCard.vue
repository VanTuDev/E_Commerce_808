<template>
  <div class="my-11">
    <div class="flex justify-between my-6">
      <h1 class="uppercase text-xl text-orange-500 font-bold">Sản phẩm mới nhất</h1>
      <div class="px-6 py-2 bg-custom-btn rounded-lg flex items-center">
        <svg
          class="text-blue-400 mr-2"
          xmlns="http://www.w3.org/2000/svg"
          height="24"
          viewBox="0 -960 960 960"
          width="24"
        >
          <path
            fill="currentColor"
            d="M280-600v-80h560v80H280Zm0 160v-80h560v80H280Zm0 160v-80h560v80H280ZM160-600q-17 0-28.5-11.5T120-640q0-17 11.5-28.5T160-680q17 0 28.5 11.5T200-640q0 17-11.5 28.5T160-600Zm0 160q-17 0-28.5-11.5T120-480q0-17 11.5-28.5T160-520q17 0 28.5 11.5T200-480q0 17-11.5 28.5T160-440Zm0 160q-17 0-28.5-11.5T120-320q0-17 11.5-28.5T160-360q17 0 28.5 11.5T200-320q0 17-11.5 28.5T160-280Z"
          />
        </svg>
        <p class="text-blue-500 font-semibold text-md">Xem tất cả</p>
      </div>
    </div>
    <BaseGrid :columns="'4'">
      <template v-slot:card>
        <div class="card shadow-xl p-5 rounded-md" v-for="product in products" :key="product.id">
          <img :src="product.imageSrc" :alt="product.imageAlt" />
          <div class="main-card">
            <a :href="product.detailLink">
              <h1 class="heading font-semibold">
                {{ product.title }}
              </h1>
            </a>
            <div class="flex">
              <p class="price text-pink-600 flex font-semibold">
                {{ product.price }}
              </p>
              <p class="underline overflow-hidden ml-1 text-pink-600 font-semibold">
                {{ product.currency }}
              </p>
            </div>
            <p class="version text-gray-400 text-sm">
              {{ product.version }}
            </p>
          </div>
        </div>
      </template>
    </BaseGrid>
  </div>
</template>
<script>
import BaseGrid from '../Grid.vue'
export default {
  components: {
    BaseGrid
  },
  data() {
    return {
      products: [
        {
          id: 1,
          title: 'Dell XPS 13 9315',
          imageSrc: './src/assets/image/Laptop.png',
          imageAlt: 'Image Description',
          detailLink: 'product-detail.html',
          price: '5.500.000 - 12.000.000',
          currency: 'đ',
          version: '3 Phiên bản'
        },
        {
          id: 2,
          title: 'Dell XPS 13 9315',
          imageSrc: './src/assets/image/Laptop.png',
          imageAlt: 'Image Description',
          detailLink: 'product-detail.html',
          price: '5.500.000 - 12.000.000',
          currency: 'đ',
          version: '4 Phiên bản'
        },
        {
          id: 3,
          title: 'Dell XPS 13 9315',
          imageSrc: './src/assets/image/Laptop.png',
          imageAlt: 'Image Description',
          detailLink: 'product-detail.html',
          price: '5.500.000 - 12.000.000',
          currency: 'đ',
          version: '5 Phiên bản'
        },
        {
          id: 4,
          title: 'Dell XPS 13 9315',
          imageSrc: './src/assets/image/Laptop.png',
          imageAlt: 'Image Description',
          detailLink: 'product-detail.html',
          price: '5.500.000 - 12.000.000',
          currency: 'đ',
          version: '6 Phiên bản'
        }
      ]
    }
  }
}
</script>
