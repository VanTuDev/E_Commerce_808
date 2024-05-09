<template>
    <div></div>
  </template>
  
  <script>
  
  export default {
    methods: {
      warning() {
        console.log(
          '%c Warning! %c If you are not a developer, this may be dangerous for your account.',
          'background: yellow; color: black; font-size: 24px; font-weight: bold;',
          'background: red; color: white; font-size: 24px;'
        );
      },
      showWarning() {
        window.addEventListener('resize', this.handleResize);
      },
      handleResize() {
        if (window.outerWidth - window.innerWidth > 100 || window.outerHeight - window.innerHeight > 100) {
          this.warning();
        }
      },
    },
    created() {
      this.showWarning();
    },
    beforeUnmount() {
      window.removeEventListener('resize', this.handleResize);
    },
  };
  </script>
  
  <style>
  /* Nếu bạn muốn thêm CSS, bạn có thể thêm ở đây */
  </style>
  