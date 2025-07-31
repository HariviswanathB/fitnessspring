package com.example.fitnessauthapp.controller;

import com.example.fitnessauthapp.model.User;
import com.example.fitnessauthapp.service.AuthService;
import com.example.fitnessauthapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("User");
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestHeader("Authorization") String token) {
        String email = JwtUtil.validateToken(token.replace("Bearer ", ""));
        return "Welcome to your dashboard, " + email;
    }
    @GetMapping("/")
    public String hello(){
        return "hi hello";
    }
}
