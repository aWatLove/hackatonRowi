package ru.chaikhana.model;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private String senderId;
    private String text;
    private Date timestamp;
}
