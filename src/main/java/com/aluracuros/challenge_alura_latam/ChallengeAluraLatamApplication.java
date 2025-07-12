package com.aluracuros.challenge_alura_latam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Foro AluraLatam", version = "1.0", description = "Documentación del Foro API"))
public class ChallengeAluraLatamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAluraLatamApplication.class, args);
	}
}
