package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageQuoteServlet")
public class ManageStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuoteRepository quoteRepository;

	public ManageQuoteServlet() {
		super();
		quoteRepository = new QuoteRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quote = quoteRepository.getRandomQuote();
		String quoteJSON = this.toJSON(quote);

		response.setContentType("text/json");
		response.getWriter().write(quoteJSON);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quote = (String)request.getParameter("quote");
		quoteRepository.addQuote(quote);
	}

	private String toJSON (String quote) {
		StringBuffer json = new StringBuffer();

		json.append("{ \"quote\" : \"");
		json.append(quote);
		json.append("\"}");

		return json.toString();
	}

}
