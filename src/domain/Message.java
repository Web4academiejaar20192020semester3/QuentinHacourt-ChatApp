package domain;

import java.time.LocalDateTime;

public class Message implements Comparable {
    private String senderID;
    private String recieverID;
    private String content;
    private LocalDateTime timestamp;

    public Message(String senderID, String recieverID, String content){
        setSenderID(senderID);
        setRecieverID(recieverID);
        setContent(content);
        setTimestamp(timestamp);
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

    private void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Object o) {
        LocalDateTime compareToTimestamp=((Message) o).getTimestamp();
        return timestamp.compareTo(compareToTimestamp);
    }
}
