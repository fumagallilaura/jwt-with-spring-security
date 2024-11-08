package com.example.jwt_with_spring_security.mappers;

import com.example.jwt_with_spring_security.dtos.UserRequestDTO;
import com.example.jwt_with_spring_security.dtos.UserResponseDTO;
import com.example.jwt_with_spring_security.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUuid(user.getUuid());
        userResponseDTO.setUserName(user.getUserName());
        return userResponseDTO;
    }
}