package controller;

// import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // Person user =  (Person) request.getSession().getAttribute("user");
    }

    @Override
    public void setModel(PersonService personService) {
        super.setModel(personService);
    }
}
