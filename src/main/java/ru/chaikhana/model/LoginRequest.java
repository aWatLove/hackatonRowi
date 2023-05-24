package ru.chaikhana.model;

import lombok.Data;

@Data
public class LoginRequest {
    String role;
    String id;

    public LoginRequest(String role, String id) {
        this.role = role;
        this.id = id;
    }
}
