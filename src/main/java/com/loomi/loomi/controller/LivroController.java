package com.loomi.loomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.services.LivroService;
import com.loomi.loomi.dto.LivroDto;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/livro")
public class LivroController {
    
    @Autowired (required = true)
    private LivroService livroService;

   @GetMapping
    public ResponseEntity <List<Livro>> buscarLivros() {
        List<Livro> livros = livroService.listarLivros();

        return ResponseEntity.ok(livros);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);

        return ResponseEntity.ok(livro);
    }
    
    @PostMapping
    public ResponseEntity<LivroDto> criarLivro(@RequestBody @Valid LivroDto livroDto) {
       Livro livro = new Livro();
       livro.setIsbn(livroDto.isbn());
       livro.setNome(livroDto.nome());
       livro.setStatus(livroDto.secoes());
       livro.setAndamento(livroDto.andamento());

    Livro salvo = livroService.criarLivro(livro);

    LivroDto response = new LivroDto(
            salvo.getIsbn(),
            salvo.getNome(),
            salvo.getSecoes(),
            salvo.getAndamento()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody @Valid LivroDto livroDto){
        
        Livro livroAtualizado = livroService.atualizaLivro(id, livroDto);

        LivroDto response = new LivroDto(
            livroAtualizado.getNome(),
            livroAtualizado.getIsbn(),
            livroAtualizado.getSecoes(),
            livroAtualizado.getAndamento()
    );

        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
