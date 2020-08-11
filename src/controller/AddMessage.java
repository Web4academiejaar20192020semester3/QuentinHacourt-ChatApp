package controller;

import domain.Message;
import domain.MessageService;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;


public class AddMessage extends RequestHandler {
    MessageService messageService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String friendID;
        String userID;
        String content;
        Person user;
        Message message;
        messageService = this.getMessageService();

        user = (Person) request.getSession().getAttribute("user");
        userID = user.getUserId();
        friendID = (String) request.getParameter("friendID");
        content = (String) request.getParameter("content");

        message = new Message(userID, friendID, content);

        messageService.addMessage(message);


        // addMessage(request.getParameter("message"));
        response.getWriter().write("200");
    }

    // private void addMessage(String messageString) throws IOException {
    //     Message message;
    //     String senderID;
    //     String recieverID;
    //     String content;
    //     Gson gson = new Gson();

    //     gson.toJson(messageString);
    //     senderID = gson.fromJson("senderID", String.class);
    //     recieverID = gson.fromJson("recieverID", String.class);
    //     content = gson.fromJson("content", String.class);
    //     message = new Message(senderID, recieverID, content);
    //     messageService.addMessage(message);
    // }
}
