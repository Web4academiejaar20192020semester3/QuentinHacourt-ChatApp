package db;

import java.util.ArrayList;
import java.util.List;

import domain.Message;

public class MessageRepositoryStub implements MessageRepository{
    private List<Message> messages;

    public MessageRepositoryStub() {
        messages = new ArrayList<>();
        Message message = new Message("jan@ucll.be", "an@ucll.be", "hi");
        messages.add(message);
    }
    @Override
    public void add(Message message) {
        messages.add(message);

    }
    @Override
    public List<Message> getMessages() {
        return messages;
    }
}
