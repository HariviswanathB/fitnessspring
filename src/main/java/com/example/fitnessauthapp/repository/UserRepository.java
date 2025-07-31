package com.example.fitnessauthapp.repository;

import com.example.fitnessauthapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
