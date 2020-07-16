package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeStatus extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {

        PersonService personService = super.getPersonService();
        request.getSession().setAttribute("status",request.getParameter("status"));
        request.getSession().setAttribute("otherText",request.getParameter("otherText"));

        personService.setStatus((String)request.getSession().getAttribute("id"),request.getParameter("status"));
        return "status.jsp";
    }
}
