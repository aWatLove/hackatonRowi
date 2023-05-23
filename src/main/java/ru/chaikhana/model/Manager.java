package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Manager {
    @Id
    private String id;
    private String managerId;
    private String name;
    private String surname;
    private String category;
}
