package com.loomi.loomi.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(@NotBlank String nome, @NotBlank String senha) {
}