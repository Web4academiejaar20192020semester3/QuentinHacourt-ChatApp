package controller;

import domain.Message;
import domain.MessageService;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Chat extends RequestHandler {
    MessageService messageService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        messageService = this.getMessageService();

        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null && request.getParameter("chat") != null) {
            response.setContentType("application/json");
            response.getWriter().write(toJSON(getRelevantMessages(user.getUserId(), request.getParameter("chat"))));
        } else if(request.getParameter("chat") == null) {
            addMessage(request.getParameter("message"));
        }
        response.getWriter().write("200");
    }

    private ArrayList<Message> getRelevantMessages(String userId, String chat) {
        ArrayList<Message> newMessages = new ArrayList<>();

        for (Message m : messageService.getMessages()) {
            if ((m.getSenderID().equals(userId) && m.getRecieverID().equals(chat)) || (m.getSenderID().equals(chat) && m.getRecieverID().equals(userId))) {
                newMessages.add(m);
            }
        }
        Collections.sort(newMessages);
        return newMessages;
    }

    public void addMessage(String messageString) throws IOException {
        Message message;
        String senderID;
        String recieverID;
        String content;
        Gson gson = new Gson();

        gson.toJson(messageString);
        senderID = gson.fromJson("senderID", String.class);
        recieverID = gson.fromJson("recieverID", String.class);
        content = gson.fromJson("content", String.class);
        message = new Message(senderID, recieverID, content);
        messageService.addMessage(message);
    }

    private String toJSON (ArrayList<Message> messages) {
        JsonObject jsonMessages = new JsonObject();
        int teller = 0;
        for (Message message : messages) {
            JsonObject jsonMessage = new JsonObject();
            jsonMessage.addProperty("senderID", message.getSenderID());
            jsonMessage.addProperty("recieverID", message.getRecieverID());
            jsonMessage.addProperty("content", message.getContent());
            jsonMessages.add("message" + Integer.toString(teller), jsonMessage);
            teller++;
        }
        return jsonMessages.toString();
    }
}
