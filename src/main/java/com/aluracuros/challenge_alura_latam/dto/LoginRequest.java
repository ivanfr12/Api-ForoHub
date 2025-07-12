package com.aluracuros.challenge_alura_latam.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String login,@NotBlank String password) {
}
