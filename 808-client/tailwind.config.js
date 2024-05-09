/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  safelist: [
    'grid',
    'xl:grid-cols-4',
    'lg:text-4xl',
],

  theme: {
    extend: {
      width: {
        'header-search-bar-custom': '50rem',
        
      },
      spacing:{
        'custom': '3.75rem',
      },
      colors: {
        'custom-bg': '#F1F3F5', // Define your custom background color here
        'custom-btn': '#E8F5FE',
      },
    },
  },
  
  plugins: [],
}