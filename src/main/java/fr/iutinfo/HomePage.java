package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/home")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		if (s.getAttribute("login") == null) {
			response.sendRedirect("login.jsp?connexion");
		} else {
			this.getServletContext().getRequestDispatcher("/homeSpectateur.jsp").forward(request, response);
		}
	}
}
