package domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message implements Comparable {
    private String messageID;
    private String senderID;
    private String recieverID;
    private String content;
    private LocalDateTime timestamp;

    public Message(String senderID, String recieverID, String content){
        setSenderID(senderID);
        setRecieverID(recieverID);
        setContent(content);
        setMessageID();
        setTimestamp();
    }

    private void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getSenderID() {
        return senderID;
    }

    private void setRecieverID(String recieverID) {
        this.recieverID = recieverID;
    }

    public String getRecieverID() {
        return recieverID;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    private void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    private void setMessageID() {
        this.messageID = UUID.randomUUID().toString();
    }

    public String getMessageID() {
        return messageID;
    }

    @Override
    public int compareTo(Object o) {
        LocalDateTime compareToTimestamp=((Message) o).getTimestamp();
        return timestamp.compareTo(compareToTimestamp);
    }
}
