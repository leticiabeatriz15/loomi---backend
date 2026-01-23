package com.loomi.loomi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.domain.livro.LivroRepository;
import com.loomi.loomi.dto.LivroDto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }

    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, LivroDto livroDto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        livro.setIsbn(livroDto.isbn());
        livro.setNome(livroDto.nome());
        livro.setStatus(livroDto.secoes());
        livro.setAndamento(livroDto.andamento());

        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new EntityNotFoundException("Livro não encontrado");
        }
        livroRepository.deleteById(id);
    }
}
