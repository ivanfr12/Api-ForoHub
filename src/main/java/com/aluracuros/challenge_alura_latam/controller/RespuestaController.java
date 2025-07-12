package com.aluracuros.challenge_alura_latam.controller;

import com.aluracuros.challenge_alura_latam.domain.Respuesta;
import com.aluracuros.challenge_alura_latam.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public List<Respuesta> listarRespuesta(){
        return respuestaRepository.findAll();
    }

    @PostMapping
    public Respuesta crearRespuesta(@RequestBody Respuesta respuesta){
        return respuestaRepository.save(respuesta);
    }
}
