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

    public void addMessage(Message message) {
        messageRepository.add(message);
    }
}
