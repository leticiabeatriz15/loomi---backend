package com.loomi.loomi.domain.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Table(name = "livros")
@Entity
public class Livro {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String isbn;

    private String nome;

    private String status;

    @Column(nullable = false)
    private Integer andamento;

    public Livro(String isbn, String nome, String status, Integer andamento){
        this.isbn = isbn;
        this.nome = nome;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAndamento() {
        return andamento;
    }

    public void setAndamento(Integer andamento) {
        this.andamento = andamento;
    }

    

}
