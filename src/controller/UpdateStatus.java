package controller;

import domain.Person;
import domain.PersonService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PersonService personService = getPersonService();
        Person person = ((Person)(request.getSession().getAttribute("user")));
        personService.setStatus(person.getUserId(), request.getParameter("status"));
        response.getWriter().write(this.toJSON(request.getParameter("status")));
    }

    @Override
    public void setModel(PersonService personService) {
        super.setModel(personService);
    }

    private String toJSON(String status){
        StringBuffer json = new StringBuffer();
        json.append("{\"status\" : \"");
        json.append(status);
        json.append("\"}");
        return json.toString();
    }
}
