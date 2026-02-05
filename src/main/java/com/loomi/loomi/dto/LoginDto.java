package com.loomi.loomi.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(@NotBlank String nome, @NotBlank String senha) {
}

