package domain;

import java.util.List;

import db.MessageRepository;
import db.MessageRepositoryStub;

public class MessageService {
    private MessageRepository messageRepository;

    public MessageService() {
        messageRepository = new MessageRepositoryStub();
    }

    public List<Message> getMessages(){
        return messageRepository.getMessages();
    }

    public void addMessage(String senderID, String recieverID, String content) {
        Message message = new Message(senderID, recieverID, content);
        messageRepository.add(message);
    }

    public void deleteMessage(String messageID) {
        messageRepository.deleteMessage(messageID);
    }
}
