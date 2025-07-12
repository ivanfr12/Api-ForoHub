package com.aluracuros.challenge_alura_latam.controller;

import com.aluracuros.challenge_alura_latam.domain.Usuario;
import com.aluracuros.challenge_alura_latam.dto.LoginRequest;
import com.aluracuros.challenge_alura_latam.dto.TokenResponse;
import com.aluracuros.challenge_alura_latam.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.login(), loginRequest.password()
        );
        var authentication = authenticationManager.authenticate(authenticationToken);


        var usuario = (Usuario) authentication.getPrincipal();
        var jwt = tokenService.generarToken(((Usuario) authentication.getPrincipal()).getLogin());

        return ResponseEntity.ok(new TokenResponse(jwt));
    }
}
