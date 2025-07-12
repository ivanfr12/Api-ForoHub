package com.aluracuros.challenge_alura_latam.controller;


import com.aluracuros.challenge_alura_latam.domain.Topico;
import com.aluracuros.challenge_alura_latam.dto.DatosActualizacionTopico;
import com.aluracuros.challenge_alura_latam.dto.DatosDetalleTopico;
import com.aluracuros.challenge_alura_latam.dto.DatosListadoTopico;
import com.aluracuros.challenge_alura_latam.dto.DatosRegistroTopico;
import com.aluracuros.challenge_alura_latam.repository.TopicoRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        // Verificar si ya existe el mismo titulo y mensaje
        boolean existe = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (existe) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo titulo y mensaje.");
        }

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setStatus(datos.status());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());
        topico.setFechaCreacion(LocalDateTime.now());

        repository.save(topico);

        return ResponseEntity.ok("Tópico registrado exitosamente.");
    }

    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    // Filtrar por nombre de curso y año
    @GetMapping("/filtrar")
    public List<DatosListadoTopico> filtrarPorCursoYAnio(
            @RequestParam String curso,
            @RequestParam int anio
    ) {
        var lista = repository.findByCursoAndAnio(curso, anio)
                .stream().map(DatosListadoTopico::new).toList();
        return lista;
    }

    // Top10
    @GetMapping("/top10")
    public List<DatosListadoTopico> top10PorFecha() {
        return repository.findTop10ByOrderByFechaCreacionAsc()
                .stream().map(DatosListadoTopico::new).toList();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerDetalle(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        if (topico.isPresent()) {
            var datos = new DatosDetalleTopico(
                    topico.get().getId(),
                    topico.get().getTitulo(),
                    topico.get().getMensaje(),
                    topico.get().getFechaCreacion(),
                    topico.get().getStatus(),
                    topico.get().getAutor(),
                    topico.get().getCurso()
            );
            return ResponseEntity.ok(datos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar topico
    @PutMapping("/{id}")
    @Transactional // actualiza automáticamente en JPA.
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());
            topico.setAutor(datos.autor());
            topico.setCurso(datos.curso());
            return ResponseEntity.ok(topico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un topico por id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        Optional<Topico> optionalTopico = repository.findById(id);
        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
    }
}
