package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MessageService;
import domain.PersonService;
import java.io.IOException;

public abstract class RequestHandler {

	private PersonService personService;
    private MessageService messageService;

	public abstract void handleRequest (HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException;

	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}

    public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
    }

    public MessageService getMessageService() {
        return messageService;
    }
}
