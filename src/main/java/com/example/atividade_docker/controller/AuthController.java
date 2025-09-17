package com.example.atividade_docker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.atividade_docker.model.Usuario;
import com.example.atividade_docker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody Usuario req) {
        System.out.println("Recebido: " + req.getEmail() + " - " + req.getSenha()); // <-- Adicione esta linha
        usuarioRepository.save(req);
        return ResponseEntity.ok(Map.of("success", true, "message", "Logado com sucesso!"));
    }

    // ...mantenha o método /nota se precisar...
}