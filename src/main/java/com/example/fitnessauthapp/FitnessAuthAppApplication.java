package com.example.fitnessauthapp;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessAuthAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessAuthAppApplication.class, args);
    }
    @PostConstruct
    public void started() {
        System.out.println("✅ Spring Boot App started successfully!");
    }

}
