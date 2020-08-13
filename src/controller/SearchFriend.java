package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class SearchFriend extends RequestHandler {
    PersonService personService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String friendID;
        String result;
        personService = this.getPersonService();
        Person person = (Person) request.getSession().getAttribute("user");

        friendID = (String) request.getParameter("friendID");
        System.out.println(friendID);
        result = personService.getFriendInfo(person.getUserId(), friendID);

        System.out.println(result);

        response.setContentType("text");
        response.getWriter().write(result);
    }
}
