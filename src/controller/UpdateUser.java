package controller;

import domain.PersonService;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


public class UpdateUser extends RequestHandler {
    PersonService personService;

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("UpdateUser");
        String email;
        String password;
        String passwordRepeat;
        String firstName;
        String lastName;
        String gender;
        int age;
        Person person;
        personService = this.getPersonService();

        email = (String) request.getParameter("email");
        password = (String) request.getParameter("password");
        passwordRepeat = (String) request.getParameter("passwordRepeat");
        firstName = (String) request.getParameter("firstName");
        lastName = (String) request.getParameter("email");
        gender = (String) request.getParameter("gender");
        age = Integer.parseInt((String) request.getParameter("age"));

        if (password.equals(passwordRepeat)){
            person = new Person(email, password, firstName, lastName, gender, age);
            personService.updatePersons(person);
        }

		request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
