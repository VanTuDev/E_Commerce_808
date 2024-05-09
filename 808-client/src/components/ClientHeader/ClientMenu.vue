<template>
    <div class="absolute  transition  delay-150 hover:transition-transform ease-linear origin-top-left opacity-100 scale-100 top-12 right-0 bg-white shadow-2xl border-1 overflow-hidden pointer-events-auto rounded-md" @click.="onClose">
      <div class="w-[14rem] h-[4.9rem] px-1 py-1">
        <div>
          <div class="flex hover:bg-custom-bg px-[10px] py-[0.35rem] mb-1 rounded-md">
            <img src="../../assets/icon/sign-in-icon.svg" alt="" class="mr-3 w-[18px]">
            <router-link :to="{name: 'sign-in'}" class="text-[0.9em] text-ellipsis">Đăng Nhập </router-link>
          </div>
          <div class="flex hover:bg-custom-bg px-[14px] py-[0.35rem] mb-2 rounded-md">
            <img src="../../assets/icon/sign-out-icon.svg" alt="" class="mr-3 w-[18px]">
            <router-link :to="{name: 'sign-up'}" class="text-[0.9em] text-ellipsis">Đăng ký</router-link>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      onClose() {
        this.$emit('cancel');
      }
    }
  };
  </script>
  