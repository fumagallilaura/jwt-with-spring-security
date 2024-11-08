package com.example.jwt_with_spring_security.services;
import com.example.jwt_with_spring_security.models.User;
import com.example.jwt_with_spring_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User userRegisterDTO) {
        User user = new User();
        user.setUserName(userRegisterDTO.getUserName());
        user.setPassword(userRegisterDTO.getPassword());
        return userRepository.save(user);
    }
}