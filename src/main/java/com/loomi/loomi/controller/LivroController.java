package com.loomi.loomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.domain.livro.LivroRepository;
import com.loomi.loomi.services.LivroService;
import com.loomi.loomi.dto.LivroDto;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/livro")
public class LivroController {
    
    @Autowired (required = true)
    private LivroService livroService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);

        return ResponseEntity.ok(livro);
    }
    
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody @Valid LivroDto livroDto) {
        Livro livro = new Livro();
        livro = livroService.criarLivro(livro);

        return ResponseEntity.ok(livro);
    }
}
