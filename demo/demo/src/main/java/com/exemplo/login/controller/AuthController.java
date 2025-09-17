package com.exemplo.login.controller;

import com.exemplo.login.model.User;
import com.exemplo.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userRepository.findById(user.getUsername()).orElse(null);
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas!";
        }
    }
}
