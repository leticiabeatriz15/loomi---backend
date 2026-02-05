package com.loomi.loomi.domain.livro;

import com.loomi.loomi.domain.enums.SecoesEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "livros")
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String isbn;

    private String nome;

    private SecoesEnum secoes;

    @Column(nullable = false)
    private Integer andamento;

    public Livro(String isbn, String nome, SecoesEnum secoes, Integer andamento){
        this.isbn = isbn;
        this.nome = nome;
        this.secoes = secoes;
        this.andamento = andamento;
    }

    public Livro(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SecoesEnum getSecoes() {
        return secoes;
    }

    public void setStatus(SecoesEnum secoes) {
        this.secoes = secoes;
    }

    public Integer getAndamento() {
        return andamento;
    }

    public void setAndamento(Integer andamento) {
        this.andamento = andamento;
    }

}
