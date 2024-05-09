<template>
  <div class="flex">
    <div class="table flex-1 my-10 m-2">
      <div class="flex mr-2 mb-5">
        <div class="text-2xl bg-blue-500 px-2 rounded-md text mr-4 text-white">#</div>
        <div class="font-semibold text-2xl">Quản lý Loại</div>
      </div>
      <div class="border">
        <DataTable
          :value="categories"
          :paginator="true"
          :rows="pageSize"
          :totalRecords="totalCategories"
          @page="onPageChange"
          :loading="loading"
          :lazy="true"
          :lazyOptions="{ onLazyLoad: loadCategories }"
        >
          <Column field="id" header="ID" sortable class=""></Column>
          <Column field="name" header="Name" sortable></Column>
          <Column field="slug" header="Slug" sortable></Column>
          <Column field="" header="Thumbnail">
            <template #body="{ data }">
              <img
                :src="data.thumbnail ? data.thumbnail : 'default-image.jpg'"
                :alt="data.thumbnail ? data.thumbnail : 'No Image'"
                class="product-image w-20 h-20"
                style=""
              />
            </template>
          </Column>
          <!-- <Column field="createdAt" header="Created At" sortable>
            <template #body="{ value }">
              {{ formatDate(value) }}
            </template>
          </Column>
          <Column field="updatedAt" header="Updated At" sortable>
            <template #body="{ value }">
              {{ formatDate(value) }}
            </template>
          </Column> -->
          <Column header="Actions" field="id">
            <template #body="{ data }">
              <button @click="editCategory(data.id)">Edit</button>
              <span>/</span>
              <button @click="deleteCategory(data.id)">Delete</button>
            </template>
          </Column>
        </DataTable>
      </div>
    </div>
    <div class="form w-[400px] border mt-[92px] p-3 hidden">
      <input type="text" v-model="category.id" />
      <div class="mb-5">
        <p class="font-medium">Tên loại <span class="text-red-500">*</span></p>
        <input
          v-model="category.name"
          class="mt-2 w-full h-9 border-solid border-2 px-5 border-gray-200 rounded-md"
          value=""
        />
      </div>
      <div class="mb-5">
        <p class="font-medium">Slug của loại <span class="text-red-500">*</span></p>
        <input
          v-model="category.slug"
          class="mt-2 w-full h-9 border-solid border-2 px-5 border-gray-200 rounded-md"
        />
      </div>
      <div class="mb-5">
        <p class="font-medium">Hình ảnh đại diện <span class="text-red-500">*</span></p>
        <file-pond
          name="image"
          ref="pond"
          label-idle="Drop files here or click here to update file"
          :allow-multiple="false"
          accepted-file-types="image/jpeg, image/png"
          :files="
            imageLink
              ? [
                  {
                    source: imageLink,
                    options: {
                      type: 'limbo',
                      poster: imageLink
                    }
                  }
                ]
              : []
          "
          :server="{
            url: '',
            process: {
              url: 'http://localhost:8080/images/upload-single',
              method: 'POST',
              onload: handleFilePondLoad
            },
            revert: handleRemoveFile
          }"
        />
      </div>
      <div class="flex justify-between text-white">
        <button class="mb-5 px-2 py-2 bg-blue-400 rounded-md">Huỷ</button>
        <button class="mb-5 px-2 py-2 bg-blue-400 rounded-md" @click="updateData">Chỉnh sửa</button>
      </div>
    </div>
  </div>
</template>

<script>
import vueFilePond from 'vue-filepond'
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
import FilePondPluginImagePreview from 'filepond-plugin-image-preview'
import FilePondPluginFilePoster from 'filepond-plugin-file-poster'
import 'filepond-plugin-file-poster/dist/filepond-plugin-file-poster.css'
import DataTable from 'primevue/datatable'
import Column from 'primevue/column'
import dayjs from 'dayjs'
import { toast } from 'vue3-toastify'
export default {
  components: {
    DataTable,
    Column,
    FilePond: vueFilePond(
      FilePondPluginFileValidateType,
      FilePondPluginImagePreview,
      FilePondPluginFilePoster
    )
  },
  data() {
    return {
      categories: [],
      category: {
        id: '',
        createAt: '',
        updateAt: '',
        name: '',
        slug: '',
        thumbnail: ''
      },
      imageLink: '',
      totalCategories: 0,
      selectedCategories: [],
      sortField: null,
      sortOrder: null,
      pageSize: 3,
      loading: false
    }
  },
  created() {
    this.loadCategories({ page: 0, size: this.pageSize })
  },
  methods: {
    async loadCategories(event) {
      try {
        this.loading = true
        const response = await fetch(
          `http://localhost:8080/api/category/find-with-paging?page=${event.page}&size=${event.size}`
        )
        const data = await response.json()
        this.categories = data.categories
        this.totalCategories = data.totalItems
      } catch (error) {
        console.error('Error fetching categories:', error)
      } finally {
        this.loading = false
      }
    },
    async editCategory(id) {
      this.imageLink = ''
      const response = await fetch(`http://localhost:8080/api/category/find-by-id/${id}`)
      const data = await response.json()
      this.category = { ...this.category, ...data }
      this.imageLink = this.imageLink.concat('' + this.category.thumbnail)
      console.log(this.imageLink)
    },
    async updateData() {
      try {
        const response = await fetch('http://localhost:8080/api/category/save', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.category)
        })
        if (!response.ok) throw new Error('Failed to add category')
        toast('Category Updated successfully!', {
          type: 'success',
          position: 'bottom-right',
          autoClose: 1000
        })

        const responseData = await response.json()
        this.category = responseData
      } catch (error) {
        console.error(error)
        toast('Category Updated Fail !', {
          type: 'error',
          position: 'bottom-right',
          autoClose: 1000
        })
      }
    },
    handleFilePondLoad(response) {
      const something = JSON.parse(response)
      this.category.thumbnail = something.path
      console.log(this.category)
      return something
    },
    async handleRemoveFile() {
      console.log(this.category)
      try {
        const response = await fetch('http://localhost:8080/api/category/update4Delete', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.category)
        })
        if (!response.ok) throw new Error('Failed to update category')
        toast('Category update successfully!', {
          type: 'success',
          position: 'bottom-right',
          autoClose: 1000
        })

        const responseData = await response.json()
        this.category = responseData
      } catch (error) {
        console.error(error)
        toast('Category update Fail !', {
          type: 'error',
          position: 'bottom-right',
          autoClose: 1000
        })
      }
    },

    async deleteCategory(rowData) {},

    onPageChange(event) {
      this.pageSize = event.rows
      this.loadCategories({
        page: event.page,
        size: event.rows,
        sortField: this.sortField,
        sortOrder: this.sortOrder
      })
    },

    formatDate(dateString) {
      return dayjs(dateString).format('DD/MM/YYYY HH:mm')
    }
  }
}
</script>
