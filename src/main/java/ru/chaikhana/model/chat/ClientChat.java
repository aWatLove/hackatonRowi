package ru.chaikhana.model.chat;

import lombok.Data;
import org.springframework.data.annotation.Id;
import ru.chaikhana.model.Message;
import ru.chaikhana.model.Product;

import java.util.List;

@Data
public class ClientChat {
    @Id
    private String id;
    private String clientId;
    private String clientName;
    private String clientSurname;
    private List<Product> clientProducts;
    private List<Message> messages;
    private String chatStatus;
    private String typeChat;
    private String managerId;
}
