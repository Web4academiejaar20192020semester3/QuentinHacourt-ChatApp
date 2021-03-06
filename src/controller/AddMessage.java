package controller;

import domain.MessageService;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class AddMessage extends RequestHandler {
    MessageService messageService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String recieverID;
        String content;
        messageService = this.getMessageService();
        Person user = (Person) request.getSession().getAttribute("user");

        recieverID = (String) request.getParameter("friendID");
        content = (String) request.getParameter("content");

        messageService.addMessage(user.getUserId(), recieverID, content);;

        response.getWriter().write("200");
    }
}
