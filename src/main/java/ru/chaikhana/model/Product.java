package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    private String id;
    private String category;
    private String title;
}
