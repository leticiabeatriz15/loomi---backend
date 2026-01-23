import axios from 'axios'

const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080'

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
})

// Interceptor para tratamento de erros
api.interceptors.response.use(
  response => response,
  error => {
    console.error('Erro na requisição:', error)
    return Promise.reject(error)
  }
)

export const livroService = {
  // Listar todos os livros
  listarLivros: () => api.get('/livro'),
  
  // Buscar livro por ID
  buscarLivroPorId: (id) => api.get(`/livro/${id}`),
  
  // Criar novo livro
  criarLivro: (livroData) => api.post('/livro', livroData),
  
  // Atualizar livro
  atualizarLivro: (id, livroData) => api.put(`/livro/${id}`, livroData),
  
  // Deletar livro
  deletarLivro: (id) => api.delete(`/livro/${id}`),
}

export const usuarioService = {
  // Listar todos os usuários
  listarUsuarios: () => api.get('/usuario'),
  
  // Buscar usuário por ID
  buscarUsuarioPorId: (id) => api.get(`/usuario/${id}`),
  
  // Criar novo usuário
  criarUsuario: (usuarioData) => api.post('/usuario', usuarioData),
  
  // Atualizar usuário
  atualizarUsuario: (id, usuarioData) => api.put(`/usuario/${id}`, usuarioData),
  
  // Deletar usuário
  deletarUsuario: (id) => api.delete(`/usuario/${id}`),
}

export default api
