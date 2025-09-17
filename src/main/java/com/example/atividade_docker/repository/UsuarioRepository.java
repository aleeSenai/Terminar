package com.example.atividade_docker.repository;

import com.example.atividade_docker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}