package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String category;
    private String title;
}
