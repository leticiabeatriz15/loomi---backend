import React, { useState, useEffect } from 'react'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import { BookOpen, Plus, LogOut } from 'lucide-react'
import BookshelfPage from './pages/BookshelfPage'
import AddBookPage from './pages/AddBookPage'
import './App.css'

function App() {
  const [usuario, setUsuario] = useState(null)

  useEffect(() => {
    // Simular usuário logado
    const usuarioSimulado = {
      id: 1,
      nome: 'Leitor Voraz'
    }
    setUsuario(usuarioSimulado)
  }, [])

  return (
    <Router>
      <div className="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100">
        {/* Header */}
        <header className="sticky top-0 z-50 bg-white shadow-sm border-b border-slate-200">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4">
            <div className="flex items-center justify-between">
              <Link to="/" className="flex items-center gap-2 group">
                <div className="bg-gradient-to-br from-indigo-600 to-pink-600 p-2 rounded-lg transform group-hover:scale-105 transition">
                  <BookOpen className="w-6 h-6 text-white" />
                </div>
                <div className="flex flex-col">
                  <span className="text-2xl font-bold bg-gradient-to-r from-indigo-600 to-pink-600 bg-clip-text text-transparent">
                    Loomi
                  </span>
                  <span className="text-xs text-slate-500">Estante Virtual</span>
                </div>
              </Link>

              {usuario && (
                <nav className="flex items-center gap-6">
                  <div className="text-sm text-slate-700">
                    Bem-vindo, <span className="font-semibold text-indigo-600">{usuario.nome}</span>
                  </div>
                  <Link
                    to="/adicionar"
                    className="flex items-center gap-2 bg-gradient-to-r from-indigo-600 to-indigo-700 text-white px-4 py-2 rounded-lg hover:from-indigo-700 hover:to-indigo-800 transition transform hover:scale-105"
                  >
                    <Plus className="w-4 h-4" />
                    Adicionar Livro
                  </Link>
                  <button className="p-2 hover:bg-slate-100 rounded-lg transition">
                    <LogOut className="w-5 h-5 text-slate-500" />
                  </button>
                </nav>
              )}
            </div>
          </div>
        </header>

        {/* Main Content */}
        <main className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
          <Routes>
            <Route path="/" element={<BookshelfPage />} />
            <Route path="/adicionar" element={<AddBookPage />} />
          </Routes>
        </main>

        {/* Footer */}
        <footer className="bg-white border-t border-slate-200 mt-16">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
            <div className="text-center text-slate-500 text-sm">
              <p>© 2024 Loomi - Sua Estante Virtual de Livros</p>
              <p className="mt-2">Compartilhe sua paixão por leitura</p>
            </div>
          </div>
        </footer>
      </div>
    </Router>
  )
}

export default App
