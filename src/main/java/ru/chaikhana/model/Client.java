package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Client")
@Data
public class Client {
    @Id
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String birthDate;
    private List<Product> products;
}
