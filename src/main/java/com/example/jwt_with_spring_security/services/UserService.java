package com.example.jwt_with_spring_security.services;

import com.example.jwt_with_spring_security.dtos.UserRequestDTO;
import com.example.jwt_with_spring_security.dtos.UserResponseDTO;
import com.example.jwt_with_spring_security.mappers.UserMapper;
import com.example.jwt_with_spring_security.models.User;
import com.example.jwt_with_spring_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }
}