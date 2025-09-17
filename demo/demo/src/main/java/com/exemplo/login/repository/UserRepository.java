package com.exemplo.login.repository;

import com.exemplo.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // Podemos adicionar consultas customizadas se necessário
}
