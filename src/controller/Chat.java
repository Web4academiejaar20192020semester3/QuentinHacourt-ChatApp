package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.PersonService;

public class Chat extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("status", "Offline");
        HttpSession session = request.getSession();
        if(session != null){
            Person person = (Person) session.getAttribute("user");
            if(person != null) {
                request.setAttribute("status", person.getStatus());
                request.setAttribute("friends", person.getFriendList());
            }
        }

        String destination = "chat.jsp";
        return destination;
    }

    @Override
    public void setModel(PersonService personService) {
        super.setModel(personService);
    }
}
