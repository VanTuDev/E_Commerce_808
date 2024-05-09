<template>
  <div class="second-part md:w-full pt-5 flex justify-between">
    <!-- Phần danh mục sản phẩm -->
    <div class="flex justify-start">
      <div
        class="header-categories font-semibold text-md lg:px-2 py-2 bg-blue-500 text-white rounded-lg flex xl:mr-8"
      >
        <img :src="categoryIcon" alt="Category Icon" class="filter invert mr-2" />
        <p class="align-baseline text-nowrap">{{ categoryText }}</p>
      </div>
      <div class="sm:hidden xl:flex 2xl:flex text-sm">
        <!-- Các link sản phẩm mới, sản phẩm xu hướng, và các link khác -->
        <a :href="newProductLink" class="text-blue-400 font-semibold text-md mx-4 my-2">
          <p>{{ newProductText }}</p>
        </a>
        <a :href="trendingProductLink" class="text-green-400 font-semibold text-md mx-4 my-2">
          <p>{{ trendingProductText }}</p>
        </a>
        <a :href="customProductLink" class="text-pink-400 font-semibold text-md mx-4 my-2">
          <p>{{ customProductText }}</p>
        </a>
      </div>
    </div>
    <!-- Phần thông báo -->
    <div>
      <div class="md:flex justify-start">
        <p
          class="logo uppercase bg-pink-500 text-xs rounded-full text-white px-3 py-1 font-bold mr-1 w-12 my-2"
        >
          {{ logoText }}
        </p>
        <p class="text-gray-400 text-sm mx-1 my-2">{{ notificationText }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    categoryIcon: {
      type: String,
      required: true
    },
    categoryText: {
      type: String,
      required: true
    },
    newProductLink: {
      type: String,
      required: true
    },
    newProductText: {
      type: String,
      required: true
    },
    trendingProductLink: {
      type: String,
      required: true
    },
    trendingProductText: {
      type: String,
      required: true
    },
    customProductLink: {
      type: String,
      required: true
    },
    customProductText: {
      type: String,
      required: true
    },
    logoText: {
      type: String,
      required: true
    },
    notificationText: {
      type: String,
      required: true
    }
  },
  
}
</script>

<!-- 
id: '',
            name: '',
            slug: '',
            thumbnail: '',
            create_at:'',
            update_at:'' -->