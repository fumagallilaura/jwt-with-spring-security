package com.example.jwt_with_spring_security.dtos;

import java.util.UUID;

public class UserResponseDTO {

    private UUID uuid;
    private String userName;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}