package controller;

import domain.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class DeleteMessage extends RequestHandler {
    MessageService messageService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String messageID;
        messageService = this.getMessageService();

        messageID = (String) request.getParameter("messageID");
        // System.out.println(messageID);
        messageService.deleteMessage(messageID);
        response.getWriter().write("200");
    }
}
