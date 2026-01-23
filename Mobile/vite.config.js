import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
    proxy: {
      '/livro': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
      '/usuario': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      }
    }
  }
})
