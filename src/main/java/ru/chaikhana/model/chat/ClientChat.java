package ru.chaikhana.model.chat;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.chaikhana.model.Message;
import ru.chaikhana.model.Product;

import java.util.List;

@Document(collection = "ClientChat")
@Data
public class ClientChat {
    @Id
    private String id;
    private String clientId;
    private String clientName;
    private String clientSurname;
    private String clientPatronymic;
    private List<Product> clientProducts;
    private List<Message> messages;
    private String chatStatus;
    private String chatCategory;
    private String managerId;
}
