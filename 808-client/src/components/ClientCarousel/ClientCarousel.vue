<template>
  <div class="flex">
    <div class="w-[64%] mr-[2rem]">
      <Carousel :autoplay="3000" :wrap-around="true" class="my-10">
        <Slide v-for="slide in 4" :key="slide">
          <div :class="currentColor" class="carousel__item">
            <!-- {{ slide }} -->
          </div>
        </Slide>

        <template #addons>
          <Pagination />
        </template>
      </Carousel>
    </div>
    <ClientMakeSure></ClientMakeSure>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue'
import { Carousel, Pagination, Slide } from 'vue3-carousel'
import ClientMakeSure from './ClientMakeSure.vue'
import 'vue3-carousel/dist/carousel.css'

export default defineComponent({
  components: {
    Carousel,
    Slide,
    Pagination,
    ClientMakeSure
  },
  setup() {
    const colors = [
      'bg-gradient-to-r from-cyan-200 to-blue-300',
      'bg-gradient-to-r from-sky-200 to-indigo-300',
      'bg-gradient-to-r from-violet-200 to-fuchsia-300',
      'bg-gradient-to-r from-emerald-100 to-emerald-300',
      'bg-gradient-to-r from-green-200 to-green-300',
      'bg-gradient-to-r from-violet-200 to-violet-300',
      'bg-gradient-to-r from-purple-200 to-purple-300',
      'bg-gradient-to-r from-fuchsia-200 to-fuchsia-300',
      'bg-gradient-to-r from-pink-200 to-pink-400',
      'bg-gradient-to-r from-rose-200 to-rose-300',
      'bg-gradient-to-r from-red-200 to-red-400'
    ]
    const currentColor = ref(colors[0])

    setInterval(() => {
      const randomIndex = Math.floor(Math.random() * colors.length)
      currentColor.value = colors[randomIndex]
    }, 900)

    return { currentColor }
  }
})
</script>
<style scoped>
.carousel__item {
  height: 392px;
  width: 100%;
  color: black;
  font-size: 20px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.carousel__item {
  width: 100%;
}
</style>
