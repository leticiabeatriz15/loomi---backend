package com.loomi.loomi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loomi.loomi.domain.livro.Livro;
import com.loomi.loomi.dto.LivroDto;
import com.loomi.loomi.services.LivroService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> listar() {
        List<LivroDto> livros = livroService.listarLivros()
                .stream()
                .map(livro -> new LivroDto(
                        livro.getId(),
                        livro.getIsbn(),
                        livro.getNome(),
                        livro.getSecoes(),
                        livro.getAndamento()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.buscarLivroPorId(id);

        LivroDto response = new LivroDto(
                livro.getId(),
                livro.getIsbn(),
                livro.getNome(),
                livro.getSecoes(),
                livro.getAndamento()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<LivroDto> criar(@RequestBody @Valid LivroDto livroDto) {
        Livro livro = new Livro();
        livro.setIsbn(livroDto.isbn());
        livro.setNome(livroDto.nome());
        livro.setStatus(livroDto.secoes());
        livro.setAndamento(livroDto.andamento());

        Livro salvo = livroService.criarLivro(livro);

        LivroDto response = new LivroDto(
                salvo.getId(),
                salvo.getIsbn(),
                salvo.getNome(),
                salvo.getSecoes(),
                salvo.getAndamento()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid LivroDto livroDto) {

        Livro atualizado = livroService.atualizarLivro(id, livroDto);

        LivroDto response = new LivroDto(
                atualizado.getId(),
                atualizado.getIsbn(),
                atualizado.getNome(),
                atualizado.getSecoes(),
                atualizado.getAndamento()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
