/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./index.html', './src/**/*.{ts,tsx,js,jsx}'],
  theme: {
    extend: {
      colors: {
        primary: '#007DFC',
      },
      gridTemplateColumns: {
        auto: 'repeat(auto-fill, minmax(200px, 1fr))',
      },
    },
  },
  plugins: [],
};
