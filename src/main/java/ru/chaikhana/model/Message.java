package ru.chaikhana.model;

import lombok.Data;

@Data
public class Message {
    private String senderId;
    private String text;
    private String timestamp;
}
