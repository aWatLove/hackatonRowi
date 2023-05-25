package ru.chaikhana.service.clientchat;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Product;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.repository.ClientChatRepository;

import java.util.List;

@Service
@Data
public class ClientChatServiceImpl implements ClientChatService {
    private final ClientChatRepository clientChatRepository;

    /*Поиск всех чатов для менеджера по его категории,
     соответсвующие запрашиваему статусу */
    @Override
    public List<ClientChat> getAllClientChatByChatCategoryAndStatus(String chatCategory, String chatStatus) {
        return clientChatRepository.findAllClientChatByChatCategoryAndChatStatus(chatCategory, chatStatus);
    }

    @Override
    public ClientChat getClientChatById(String id) {
        return clientChatRepository.findById(id).orElse(null);
    }

    @Override
    public ClientChat addClientChat(ClientChat clientChat) {
        return clientChatRepository.save(clientChat);
    }

    @Override
    public void deleteClientChat(ClientChat clientChat) {
        clientChatRepository.delete(clientChat);
    }

    @Override
    public ClientChat updateClientChat(ClientChat clientChat) {
        return clientChatRepository.save(clientChat);
    }

    @Override
    public List<ClientChat> getAllOpenNotBusyChat() {
        return clientChatRepository.findAllClientChatByChatStatus("isOpenNotBusy");
    }

    //Поиск чата по Id клиента
    @Override
    public ClientChat getClientChatByClientId(String clientId) {
        return clientChatRepository.findClientChatByClientId(clientId).orElse(null);
    }
    //Изменение Категории Чата при перенаправлении от одного Менеджера к другому
    @Override
    public void changeClientChatCategory(String chatCategory, String clientId){
        ClientChat clientChat = getClientChatByClientId(clientId);
        clientChat.setChatCategory(chatCategory);
        updateClientChat(clientChat);
    }
    //Изменение Статуса Чата при решении проблемы, входе в чат Менеджера и т.д.
    @Override
    public void changeClientChatStatus(String chatStatus, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        if(chatStatus.equals("isClosed")){
            clientChat.setManagerId(null);
        }
        clientChat.setChatStatus(chatStatus);
        updateClientChat(clientChat);
    }
    /*Удаление и ниже добавление продукта в чат пользователя,
     для быстрого доступа к общей информации*/
    @Override
    public void deleteProductInClientChat(Product product, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        if(clientChat!=null){
            clientChat.getClientProducts().remove(product);
            updateClientChat(clientChat);
        }
    }

    @Override
    public void addProductInClientChat(Product product, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        if(clientChat!=null){
            clientChat.getClientProducts().add(product);
            updateClientChat(clientChat);
        }
    }
    /*Изменение Id менеджера при входе Менеджера в чат,
     если войдёт другой менеджер, id изменится, если вопрос решён, заNULLится*/
    @Override
    public void changeManagerIdInClientChat(String managerId, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
       if(clientChat.getChatStatus().equals("isOpenNotBusy")){
           clientChat.setChatStatus("isOpenAndBusy");
       }
       clientChat.setManagerId(managerId);
       updateClientChat(clientChat);
    }
}
