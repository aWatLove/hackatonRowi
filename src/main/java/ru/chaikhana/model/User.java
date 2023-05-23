package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String id;
    private String role;
    private String login;
    private String password;
    private String eMail;
    private String idForeign;
}
