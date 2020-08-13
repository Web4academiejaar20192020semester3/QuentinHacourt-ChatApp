package controller;

import domain.Message;
import domain.MessageService;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;


public class GetChat extends RequestHandler {
    MessageService messageService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String friendID;
        String userID;
        Person user;
        ArrayList<Message> relevantMessages;
        String json;

        messageService = this.getMessageService();
        friendID = (String) request.getParameter("friendID");
        user = (Person) request.getSession().getAttribute("user");
        userID = user.getUserId();

        relevantMessages = getRelevantMessages(userID, friendID);

        json = toJSON(relevantMessages);

        response.setContentType("application/json");
        response.getWriter().write(json);
        // response.getWriter().write("200");
    }

    private ArrayList<Message> getRelevantMessages(String userID, String friendID) {
        ArrayList<Message> relevantMessages = new ArrayList<>();

        for (Message m : messageService.getMessages()) {
            if ((m.getSenderID().equals(userID) && m.getRecieverID().equals(friendID)) || (m.getSenderID().equals(friendID) && m.getRecieverID().equals(userID))) {
                relevantMessages.add(m);
            }
        }

        // Collections.sort(newMessages);
        return relevantMessages;
    }

    private String toJSON (ArrayList<Message> messages) {
        int teller = 0;
        JsonArray jsonMessages = new JsonArray();
        for (Message message : messages) {
            JsonObject jsonMessage = new JsonObject();
            jsonMessage.addProperty("id", Integer.toString(teller));
            jsonMessage.addProperty("senderID", message.getSenderID());
            jsonMessage.addProperty("recieverID", message.getRecieverID());
            jsonMessage.addProperty("content", message.getContent());
            jsonMessage.addProperty("messageID", message.getMessageID());
            jsonMessages.add(jsonMessage);
            teller++;
        }
        return jsonMessages.toString();
    }
}
