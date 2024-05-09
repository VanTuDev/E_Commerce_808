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
    <div class="mx-[30rem] my-20">
      <div class="my-[2rem]"><p class="font-bold text-center text-2xl">Đăng ký tài khoản</p></div>
      <a-steps :current="current">
        <a-step v-for="item in steps" :key="item.title" :title="item.title" />
      </a-steps>
      <div class="border border-white-500 h-auto mx-36 my-16 px-6 rounded-lg">
        <div class="px-10 py-10">
            <div v-if="current === 0">
                <div class="flex flex-col gap-2 mb-5">
                    <label for="" class="text-sm font-semibold">Tên tài khoản</label>
                    <input id="" v-model="email" type="text" placeholder="Nhập tên tài khoản"
                           class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500 placeholder-gray-400::placeholder" >
                    {{ email }}
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="" class="text-sm font-semibold">Mật khẩu</label>
                    <input id="" v-model="value" type="text" placeholder="Nhập mật khẩu"
                           class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500 placeholder-gray-400::placeholder" >
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="" class="text-sm font-semibold">Họ và tên</label>
                    <input id="" v-model="value" type="text" placeholder="Nhập họ và tên"
                           class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500 placeholder-gray-400::placeholder" >
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="" class="text-sm font-semibold">Email</label>
                    <input id="" v-model="value" type="text" placeholder="Nhập email"
                           class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500 placeholder-gray-400::placeholder" >
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="gender" class="text-sm font-semibold">Giới tính</label>
                    <select id="gender" v-model="selectedGender" 
                            class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500">
                            <option value="" disabled selected>Chọn giới tính</option>
                            <option value="male">Nam</option>
                            <option value="female">Nữ</option>
                    </select>
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="province" class="text-sm font-semibold">Tỉnh/Thành phố</label>
                    <select id="province" v-model="selectedProvince" 
                            class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500">
                      <option value="" disabled selected>Chọn tỉnh/thành phố</option>
                      <option v-for="province in provinces" :key="province.id" :value="province.id">{{ province.name }}</option>
                    </select>
                </div>
                  <div class="flex flex-col gap-2 mb-5">
                    <label for="district" class="text-sm font-semibold">Quận/Huyện</label>
                    <select id="district" v-model="selectedDistrict" 
                            class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500">
                      <option value="" disabled selected>Chọn quận/huyện</option>
                      <option v-for="district in districts" :key="district.id" :value="district.id">{{ district.name }}</option>
                    </select>
                </div>
                  <div class="flex flex-col gap-2 mb-5">
                    <label for="ward" class="text-sm font-semibold">Phường/Xã</label>
                    <select id="ward" v-model="selectedWard" 
                            class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500">
                      <option value="" disabled selected>Chọn phường/xã</option>
                      <option v-for="ward in wards" :key="ward.id" :value="ward.id">{{ ward.name }}</option>
                    </select>
                </div>
                <div class="flex flex-col gap-2 mb-5">
                    <label for="detail-address" class="text-sm font-semibold">Địa chỉ chi tiết</label>
                    <input id="detail-address" v-model="detailAddress" type="text" placeholder="Nhập địa chỉ chi tiết..."
                           class="border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:border-blue-500 placeholder-gray-400::placeholder">
                </div>
                <div class="steps-action">
                    <a-button type="primary" @click="next">Đăng ký</a-button> 
                </div>
              </div>
              <div v-else-if="current === 1">
                
                <form @submit.prevent="handleSubmit">
                    <p class="text-center">Nhập mã ở bên dưới</p>
                    <div class="flex justify-center items-center gap-2">
                        <input v-model="otp[0]" type="text" maxlength="1" class="w-12 h-12 text-2xl text-center border border-gray-300 rounded-md">
                        <input v-model="otp[1]" type="text" maxlength="1" class="w-12 h-12 text-2xl text-center border border-gray-300 rounded-md ">
                        <input v-model="otp[2]" type="text" maxlength="1" class="w-12 h-12 text-2xl text-center border border-gray-300 rounded-md ">
                        <input v-model="otp[3]" type="text" maxlength="1" class="w-12 h-12 text-2xl text-center border border-gray-300 rounded-md ">
                    </div>     
                  <div class="steps-action">
                    <a-button type="primary" @click="next">Next</a-button>
                  </div>
                </form>
              </div>
              <div v-else>Đăng ký thành công</div>
        </div>
      </div>
      
    </div>
  </template>
  <script>
  import BaseHeader from '../../components/ClientHeader/ClientHeader.vue'
  
  export default {
    components: {
      BaseHeader,
    },
    data() {
      return {
        current: 0,
        inputValue: '',
        email: '',
        password: '',
        steps: [
          {
            title: 'Tạo tài khoản'
          },
          {
            title: 'Xác nhận email'
          },
          {
            title: 'Đăng kí thành công'
          }
        ],
        otp: ['', '', '', ''] // Di chuyển khai báo dữ liệu otp vào đây
      }
    },
    methods: {
      next() {
        if (this.current < this.steps.length - 1) {
          this.current++
        }
      },
      prev() {
        if (this.current > 0) {
          this.current--
        }
      },
      handleDone() {
        console.log('Processing complete!')
      },
      handleSubmit() {
        console.log('Form submitted!')
      },
      submitOTP() {
        // Xử lý mã OTP ở đây
        const otpCode = this.otp.join(''); // Kết hợp các ô input thành một mã OTP
        console.log('Mã OTP:', otpCode);
      }
    }
  }
  </script>
  
  
  <style scoped>
  .steps-content {
    margin-top: 16px;
    border: 1px dashed #e9e9e9;
    border-radius: 6px;
    background-color: #fafafa;
    min-height: 200px;
    text-align: center;
    padding-top: 20px;
  }
  
  .steps-action {
    margin-top: 24px;
  }
  
  .ant-btn-primary {
    background-color: #1890ff;
    border-color: #1890ff;
  }
  .ant-btn-primary:hover {
    background-color: #40a9ff;
    border-color: #40a9ff;
  }
  </style>
  