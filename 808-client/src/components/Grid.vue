<template>
  <div :class="gridClass">
    <slot name="card"></slot>
  </div>
</template>

<script>
export default {
  name: 'ProductCardGrid',
  props: {
    columns: {
      type: String,
      required: true 
    },
    responsive: {
      type: String,
      default: 'xl' 
    }
  },
  computed: {
    gridClass() {
      let classes = {
        'grid': true,
        'gap-3': true,
      };

      classes[`${this.responsive}:grid-cols-${this.columns}`] = true;
      return classes;
    }
  }
}
</script>
