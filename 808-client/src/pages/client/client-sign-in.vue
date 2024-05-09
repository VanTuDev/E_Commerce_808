<template>
  <header class="w-full md:h-36 shadow-xl pt-3">
    <div class="sm:mx-52">
      <BaseHeader
        logoText="808"
        searchBarClass="'md:w-96 xl:w-96 2xl:w-header-search-bar-custom'"
        cartIcon="./src/assets/icon/cart-icon.svg"
        ringIcon="./src/assets/icon/ring-icon.svg"
        avatarIcon="./src/assets/icon/avatar-icon.svg"
      />
      <CategoryMenu
        categoryIcon="./src/assets/icon/category-icon.svg"
        categoryText="Danh mục sản phẩm"
        newProductLink="#"
        newProductText="Sản phẩm mới"
        trendingProductLink="#"
        trendingProductText="Sản phẩm xu hướng"
        customProductLink="#"
        customProductText="Sản phẩm đang khuyển mãi"
        logoText="hot"
        notificationText="Miễn phí giao hàng cho đơn hàng trên 1 triệu đồng"
      />
    </div>
  </header>

</template>

<script>
import BaseHeader from '../../components/ClientHeader/ClientHeader.vue'
export default {
    components:{
        BaseHeader
    },
  
}
</script>
<style scoped>
</style>
