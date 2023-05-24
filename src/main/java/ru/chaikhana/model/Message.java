package ru.chaikhana.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


//Это временное решение, мессаге не коллекция
@Document(collection = "Message")
@Data
public class Message {
    private String senderId;
    private String text;
    private String timestamp;
}
