<template>
  <div class="flex justify-between">
    <h1 class="uppercase text-xl text-orange-500 font-bold">Danh mục sản phẩm</h1>
    <div class="px-3 py-2 bg-custom-btn rounded-lg flex items-center">
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
  <div class="category mt-10 grid gap-3 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
    <div
      class="xl:px-4 py-6 pb-6 rounded-md text-md shadow-xl flex bg-white"
      v-for="category in categories"
      :key="category.id"
    >
      <img :src="category.thumbnail" alt="" class="mr-3" />

      <router-link :to="{ name: 'client-home' }" class="text-[0.9em] text-ellipsis">
        <p>{{ category.name }}</p>
      </router-link>
    </div>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      categories: []
    }
  },
  created() {
    this.fetchCategories()
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await fetch('http://localhost:8080/api/category/find-all')
        if (!response.ok) {
          throw new Error('Failed to fetch categories')
        }
        const data = await response.json()
        this.categories = data
      } catch (error) {
        console.error('Error fetching categories:', error)
      }
    }
  }
}
</script>

<style></style>
