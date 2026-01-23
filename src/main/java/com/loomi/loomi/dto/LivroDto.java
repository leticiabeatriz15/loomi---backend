package com.loomi.loomi.dto;

import com.loomi.loomi.domain.enums.SecoesEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto(Long id, @NotBlank String isbn, @NotBlank String nome, SecoesEnum secoes, @NotNull Integer andamento){
}
