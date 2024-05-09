<template>
  <Warning></Warning>
  <header class="w-full md:h-36 shadow-xl pt-3">
    <div class="mx-52">
      <BaseHeader
        logoText="808"
        searchBarClass=" xl:w-96 2xl:w-header-search-bar-custom"
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
  <div class="mx-52">
    <BaseCarousel></BaseCarousel>
    <BaseCategory></BaseCategory>
    <BaseProduct></BaseProduct>
    <SignUpForNotice></SignUpForNotice>
  </div>
  <BaseFooter></BaseFooter>
</template>
<script>
import BaseHeader from '../../components/ClientHeader/ClientHeader.vue'
import CategoryMenu from '../../components/ClientHeader/CategoryMenu.vue'
import BaseFooter from '../../components/ClientFooter/ClientFooter.vue'
import BaseCarousel from '../../components/ClientCarousel/ClientCarousel.vue'
import BaseProduct from '../../components/ClientProductCard/ClientProductCard.vue'
import BaseCategory from '../../components/ClientCategory/ClientCategory.vue'
import SignUpForNotice from '../../components/ClientGeneral/SignupForNotice.vue'

import Warning from '../../components/ClientGeneral/Warning.vue'

export default {
  components: {
    BaseHeader,
    CategoryMenu,
    BaseCarousel,
    BaseCategory,
    BaseProduct,
    SignUpForNotice,
    BaseFooter,
    Warning
  },
  data() {
    return {}
  }
}
</script>
<style></style>
