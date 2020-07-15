package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;

public abstract class RequestHandler {

	private PersonService personService;

	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}
}
