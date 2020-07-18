package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return ((Person)(request.getSession().getAttribute("user"))).getStatus();
    }

    @Override
    public void setModel(PersonService personService) {
        super.setModel(personService);
    }
}
