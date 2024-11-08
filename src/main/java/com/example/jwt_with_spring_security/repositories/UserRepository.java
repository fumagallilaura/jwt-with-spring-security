package com.example.jwt_with_spring_security.repositories;

import com.example.jwt_with_spring_security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
