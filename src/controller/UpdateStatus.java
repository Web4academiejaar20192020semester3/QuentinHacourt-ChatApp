package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatus extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("STATUS");
        PersonService personService = super.getPersonService();
        request.getSession().setAttribute("status",request.getParameter("status"));
        request.getSession().setAttribute("otherText",request.getParameter("otherText"));

        personService.setStatus((String)request.getSession().getAttribute("personId"),request.getParameter("status"));
        return "chat.jsp";
    }

    @Override
    public void setModel(PersonService personService) {
        super.setModel(personService);
    }
}
