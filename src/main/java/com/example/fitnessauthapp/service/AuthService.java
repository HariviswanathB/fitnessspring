package com.example.fitnessauthapp.service;

import com.example.fitnessauthapp.model.User;
import com.example.fitnessauthapp.repository.UserRepository;
import com.example.fitnessauthapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return "Invalid credentials!";
        }
        return jwtUtil.generateToken(email);
    }
}
