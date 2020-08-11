package db;

import java.util.List;

import domain.Message;

public interface MessageRepository {
    public abstract void add(Message message);

    public abstract List<Message> getMessages();
}
