package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;

public class LogOut extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
        Person person = (Person)session.getAttribute("user");
        person.setStatus("Offline");
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
