package com.aluracuros.challenge_alura_latam.repository;

import com.aluracuros.challenge_alura_latam.domain.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.fechaCreacion) = :anio")
    List<Topico> findByCursoAndAnio(@Param("curso") String curso, @Param("anio") int anio);

    List<Topico> findTop10ByOrderByFechaCreacionAsc();
}
