import React, { useState } from 'react'
import { X, CheckCircle } from 'lucide-react'
import { livroService } from '../services/api'

function EditBookModal({ livro, isOpen, onClose, onUpdate }) {
  const [loading, setLoading] = useState(false)
  const [formData, setFormData] = useState({
    secoes: livro?.secoes || 'QUERO_LER',
    andamento: livro?.andamento || 0
  })

  const handleStatusChange = (status) => {
    setFormData(prev => ({
      ...prev,
      secoes: status,
      andamento: status === 'LENDO' ? prev.andamento : (status === 'LIDO' ? 100 : 0)
    }))
  }

  const handleProgressChange = (e) => {
    setFormData(prev => ({
      ...prev,
      andamento: parseInt(e.target.value)
    }))
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      setLoading(true)
      const updateData = {
        id: livro.id,
        isbn: livro.isbn,
        nome: livro.nome,
        secoes: formData.secoes,
        andamento: formData.andamento
      }
      await livroService.atualizarLivro(livro.id, updateData)
      onUpdate({...livro, ...formData})
      onClose()
    } catch (error) {
      console.error('Erro ao atualizar livro:', error)
      alert('Erro ao atualizar livro')
    } finally {
      setLoading(false)
    }
  }

  if (!isOpen || !livro) return null

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
      <div className="bg-white rounded-lg shadow-xl max-w-md w-full animate-fadeIn">
        {/* Header */}
        <div className="flex items-center justify-between p-6 border-b border-slate-200">
          <h2 className="text-xl font-bold text-slate-900">Atualizar Progresso</h2>
          <button
            onClick={onClose}
            className="p-1 hover:bg-slate-100 rounded-lg transition"
          >
            <X className="w-5 h-5 text-slate-500" />
          </button>
        </div>

        {/* Conteúdo */}
        <form onSubmit={handleSubmit} className="p-6 space-y-6">
          {/* Info do Livro */}
          <div className="bg-slate-50 p-4 rounded-lg">
            <p className="text-sm text-slate-600">
              <span className="font-semibold text-slate-900">{livro.nome}</span>
            </p>
            <p className="text-xs text-slate-500 mt-1">ISBN: {livro.isbn}</p>
          </div>

          {/* Opções de Status */}
          <div className="space-y-3">
            <label className="block text-sm font-semibold text-slate-700">
              Status de Leitura
            </label>
            
            <div className="space-y-2">
              {/* Quero Ler */}
              <button
                type="button"
                onClick={() => handleStatusChange('QUERO_LER')}
                className={`w-full flex items-center gap-3 p-3 rounded-lg border-2 transition ${
                  formData.secoes === 'QUERO_LER'
                    ? 'border-pink-500 bg-pink-50'
                    : 'border-slate-200 bg-white hover:border-slate-300'
                }`}
              >
                <div className={`w-5 h-5 rounded-full border-2 flex items-center justify-center ${
                  formData.secoes === 'QUERO_LER'
                    ? 'border-pink-500 bg-pink-500'
                    : 'border-slate-300'
                }`}>
                  {formData.secoes === 'QUERO_LER' && (
                    <CheckCircle className="w-4 h-4 text-white" />
                  )}
                </div>
                <div className="text-left">
                  <p className="text-sm font-medium text-slate-900">Quero Ler</p>
                  <p className="text-xs text-slate-500">Você ainda não começou este livro</p>
                </div>
              </button>

              {/* Lendo */}
              <button
                type="button"
                onClick={() => handleStatusChange('LENDO')}
                className={`w-full flex items-center gap-3 p-3 rounded-lg border-2 transition ${
                  formData.secoes === 'LENDO'
                    ? 'border-blue-500 bg-blue-50'
                    : 'border-slate-200 bg-white hover:border-slate-300'
                }`}
              >
                <div className={`w-5 h-5 rounded-full border-2 flex items-center justify-center ${
                  formData.secoes === 'LENDO'
                    ? 'border-blue-500 bg-blue-500'
                    : 'border-slate-300'
                }`}>
                  {formData.secoes === 'LENDO' && (
                    <CheckCircle className="w-4 h-4 text-white" />
                  )}
                </div>
                <div className="text-left">
                  <p className="text-sm font-medium text-slate-900">Estou Lendo</p>
                  <p className="text-xs text-slate-500">Você está no meio da leitura</p>
                </div>
              </button>

              {/* Lido */}
              <button
                type="button"
                onClick={() => handleStatusChange('LIDO')}
                className={`w-full flex items-center gap-3 p-3 rounded-lg border-2 transition ${
                  formData.secoes === 'LIDO'
                    ? 'border-green-500 bg-green-50'
                    : 'border-slate-200 bg-white hover:border-slate-300'
                }`}
              >
                <div className={`w-5 h-5 rounded-full border-2 flex items-center justify-center ${
                  formData.secoes === 'LIDO'
                    ? 'border-green-500 bg-green-500'
                    : 'border-slate-300'
                }`}>
                  {formData.secoes === 'LIDO' && (
                    <CheckCircle className="w-4 h-4 text-white" />
                  )}
                </div>
                <div className="text-left">
                  <p className="text-sm font-medium text-slate-900">Já Li</p>
                  <p className="text-xs text-slate-500">Você terminou de ler este livro</p>
                </div>
              </button>
            </div>
          </div>

          {/* Progresso (se estiver lendo) */}
          {formData.secoes === 'LENDO' && (
            <div className="bg-blue-50 p-4 rounded-lg border border-blue-200">
              <label className="block text-sm font-semibold text-slate-700 mb-3">
                Progresso de Leitura: {formData.andamento}%
              </label>
              <input
                type="range"
                min="0"
                max="100"
                value={formData.andamento}
                onChange={handleProgressChange}
                className="w-full h-2 bg-blue-200 rounded-lg appearance-none cursor-pointer accent-blue-600"
              />
              <div className="flex justify-between text-xs text-slate-600 mt-2">
                <span>0%</span>
                <span>50%</span>
                <span>100%</span>
              </div>
            </div>
          )}

          {/* Botões */}
          <div className="flex gap-3 pt-4 border-t border-slate-200">
            <button
              type="button"
              onClick={onClose}
              className="flex-1 px-4 py-2 border border-slate-300 text-slate-700 rounded-lg hover:bg-slate-50 transition font-medium"
            >
              Cancelar
            </button>
            <button
              type="submit"
              disabled={loading}
              className="flex-1 px-4 py-2 bg-gradient-to-r from-indigo-600 to-pink-600 text-white rounded-lg hover:from-indigo-700 hover:to-pink-700 transition font-medium disabled:opacity-50"
            >
              {loading ? 'Atualizando...' : 'Atualizar'}
            </button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default EditBookModal
