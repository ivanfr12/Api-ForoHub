package com.aluracuros.challenge_alura_latam.repository;

import com.aluracuros.challenge_alura_latam.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
