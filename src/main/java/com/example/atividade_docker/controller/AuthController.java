package com.example.atividade_docker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.atividade_docker.dto.LoginRequest;
import com.example.atividade_docker.dto.NotaRequest;
import java.util.Map;

@RestController
@RequestMapping("/api") // todas as rotas começam com /api
@CrossOrigin(origins = "*") // libera CORS para testes (se o front estiver rodando em porta diferente)
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginRequest req) {
        if ("1234".equals(req.password())) {
            return ResponseEntity.ok(Map.of("success", true, "message", "Logado com sucesso!"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(Map.of("success", false, "message", "Credenciais inválidas"));
        }
    }

    @PostMapping("/nota")
    public ResponseEntity<Map<String,Object>> nota(@RequestBody NotaRequest req) {
        return ResponseEntity.ok(Map.of("received", req.notaMaxima()));
    }
}
