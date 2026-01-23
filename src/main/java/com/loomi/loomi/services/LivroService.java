package com.loomi.loomi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.domain.livro.LivroRepository;
import com.loomi.loomi.dto.LivroDto;

import jakarta.persistence.EntityNotFoundException;

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

    public Livro atualizaLivro(Long id, LivroDto livroDto){
        
    Livro livro = livroRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

    livro.setIsbn(livroDto.isbn());
    livro.setNome(livroDto.nome());
    livro.setStatus(livroDto.secoes());
    livro.setAndamento(livroDto.andamento());

    return livroRepository.save(livro);
    }


    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }
}

