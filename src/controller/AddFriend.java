package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Person person = (Person) request.getSession().getAttribute("user");
        String friendId = request.getParameter("friendId");
        try{
            getPersonService().addFriend(person.getUserId(), friendId);
        }
        catch (Exception e){
            throw new IOException("This person doesn't exist.");
        }
    }
}
