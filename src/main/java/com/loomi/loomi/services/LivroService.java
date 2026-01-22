package com.loomi.loomi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.domain.livro.LivroRepository;

@Service
public class LivroService {

    @Autowired (required = true)
    private LivroRepository livroRepository;

    public Livro buscarLivroPorId(Long id) {
        Livro livro = this.livroRepository.findById(id).orElse(null);
        return livro;
    }
    
    public Livro criarLivro(Livro livro){
        return livroRepository.save(livro);
    }
}

