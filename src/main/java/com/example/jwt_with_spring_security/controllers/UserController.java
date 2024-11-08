package com.example.jwt_with_spring_security.controllers;

import com.example.jwt_with_spring_security.dtos.UserRequestDTO;
import com.example.jwt_with_spring_security.dtos.UserResponseDTO;
import com.example.jwt_with_spring_security.mappers.UserMapper;
import com.example.jwt_with_spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.save(userRequestDTO);
    }
}