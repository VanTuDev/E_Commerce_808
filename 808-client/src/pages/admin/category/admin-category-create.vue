<template>
  <main class="flex sm:mx-52 mt-16 gap-3">
    <div class="w-3/4 h-full">
      <div class="flex gap-5">
        <a
          href="#"
          class="bg-blue-500 p-2 w-8 h-8 flex items-center justify-center rounded-md text-white"
        >
          <i class="fa-solid fa-chevron-left"></i>
        </a>
        <p class="text-2xl font-bold">Thêm Loại<span class="font-mono text-xs">#Category</span></p>
      </div>
      <form @submit.prevent="addCategory">
        <div class="mt-5 p-5 bg-white rounded-lg shadow-md ">
          <div class="text-xl font-bold">Thông tin cơ bản</div>
          <p>Một số thông tin chung</p>
          <div class="mt-5">
            <p class="font-medium">Tên loại <span class="text-red-500">*</span></p>
            <input
              v-model="category.name"
              class="mt-2 w-full h-10 border-solid border-2 px-5 border-gray-200 rounded-md"
            />
          </div>
          <div class="mt-5">
            <p class="font-medium">Slug <span class="text-red-500">*</span></p>
            <input
              v-model="category.slug"
              class="mt-2 w-full h-10 border-solid border-2 px-5 border-gray-200 rounded-md"
            />
          </div>
          <div>
            <div class="text-xl mt-5 font-bold">Thumbnail</div>
            <p class="my-2 mb-2">Thêm Icon đại diện cho loại</p>
            <file-pond
              name="image"
              ref="pond"
              label-idle="Drop files here or click here to update file"
              :allow-multiple="false"
              accepted-file-types="image/jpeg, image/png"
              :server="{
                url: '',
                process: {
                  url: 'http://localhost:8080/images/upload-single',
                  method: 'POST',
                  onload: handleFilePondLoad
                }
              }"
            />
          </div>

          <div class="mt-10 flex justify-between">
            <button
              class="text-center font-semibold py-2 px-5 border-solid border-2 border-gray-200 rounded-lg"
              type="reset"
            >
              Mặc định
            </button>
            <button
              class="bg-[#228be6] py-2 px-5 font-semibold text-white rounded-lg"
              type="submit"
            >
              Thêm
            </button>
          </div>
        </div>
      </form>
    </div>
  </main>
</template>
<script>
import vueFilePond from 'vue-filepond'
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
import FilePondPluginImagePreview from 'filepond-plugin-image-preview'
const FilePond = vueFilePond(FilePondPluginFileValidateType, FilePondPluginImagePreview)
import { toast } from 'vue3-toastify'

export default {
  components: {
    FilePond
  },
  data() {
    return {
      category: {
        id: '',
        create_at: '',
        name: '',
        thumbnail: '',
        slug: ''
      }
    }
  },
  methods: {
    async addCategory() {
      try {
        const response = await fetch('http://localhost:8080/api/category/save', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.category)
        })
        if (!response.ok) throw new Error('Failed to add category')
        toast('Category added successfully!', {
          type: 'success',
          position: 'bottom-right',
          autoClose: 1000
        })

        const responseData = await response.json()
        this.category = responseData
      } catch (error) {
        console.error(error)
        toast('Category added Fail !', {
          type: 'error',
          position: 'bottom-right',
          autoClose: 1000
        })
      }
    },
    handleFilePondInit() {
      console.log('FilePond has initialized')
    },
    handleFilePondLoad(response) {
      const something = JSON.parse(response)
      this.category.thumbnail = something.path
      return something
    }
  }
}
</script>
