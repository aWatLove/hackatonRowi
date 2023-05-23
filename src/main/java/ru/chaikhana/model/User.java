package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String id;
    private String name;
    private String surname;
    private String patronymic;
}
