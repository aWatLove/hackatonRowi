package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Manager")
public class Manager {
    @Id
    private String id;
    private String name;
    private String surname;
    private String category;
}
