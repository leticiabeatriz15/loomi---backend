package com.loomi.loomi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.domain.livro.LivroRepository;
import com.loomi.loomi.dto.LivroDto;
import com.loomi.loomi.exception.BusinessException;
import com.loomi.loomi.exception.ResourceNotFoundException;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        try {
            return livroRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("Erro ao listar livros", e);
        }
    }

    public Livro buscarLivroPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        return livroRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Livro", "id", id));
    }

    public Livro criarLivro(Livro livro) {
        try {
            validarLivro(livro);
            if (livro.getIsbn() != null && !livro.getIsbn().isEmpty()) {
            }
            
            return livroRepository.save(livro);
        } catch (BusinessException | IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao criar livro", e);
        }
    }

    public Livro atualizarLivro(Long id, LivroDto livroDto) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        try {
            Livro livro = livroRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Livro", "id", id));

            livro.setIsbn(livroDto.isbn());
            livro.setNome(livroDto.nome());
            livro.setStatus(livroDto.secoes());
            livro.setAndamento(livroDto.andamento());

            return livroRepository.save(livro);
        } catch (ResourceNotFoundException | IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar livro", e);
        }
    }

    public void deletarLivro(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        
        try {
            if (!livroRepository.existsById(id)) {
                throw new ResourceNotFoundException("Livro", "id", id);
            }
            livroRepository.deleteById(id);
        } catch (ResourceNotFoundException | IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao deletar livro", e);
        }
    }
    
    private void validarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        
        if (livro.getNome() == null || livro.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do livro é obrigatório");
        }
        
        if (livro.getIsbn() == null || livro.getIsbn().trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN do livro é obrigatório");
        }
    }
}
