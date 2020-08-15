package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

public class GetUsers extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String res;
        response.setContentType("application/json");
        try{
            //res = "{\"users\":";
            res = toJson(getPersonService().getPersons());
            //res += "}";
            System.out.println(res);
            response.getWriter().write(res);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String toJson(List<Person> list) {
        JsonArray json = new JsonArray();
        for (Person person : list) {
            JsonObject user = new JsonObject();
            user.addProperty("naam", person.getLastName());
            user.addProperty("voornaam", person.getFirstName());
            user.addProperty("email", person.getUserId());
            user.addProperty("geslacht", person.getGender());
            user.addProperty("leeftijd", Integer.toString(person.getAge()));
            user.addProperty("userStatus", person.getStatus());
            json.add(user);
        }
        return json.toString();
    }
}
