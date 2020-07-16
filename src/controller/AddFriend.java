package controller;

import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {

        PersonService personService = super.getPersonService();
        String friendId = request.getParameter("friendId");
        if(friendId!=null)
        {
            String personId = (String)request.getSession().getAttribute("personId");
            personService.addFriend(personId, friendId);
        }
        return "";
    }
}
