package com.example.jwt_with_spring_security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
// Em alguns bancos de dados, como o PostgreSQL, user é uma palavra reservada. Se você tentar criar uma tabela com esse nome, pode haver conflitos ou erros. Usar @Table(name = "users") permite que você evite esse problema, escolhendo um nome de tabela que não entre em conflito com palavras reservadas.
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    // Construtor padrão
    public User() {
    }

    // Construtor com parâmetros
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getters e Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}