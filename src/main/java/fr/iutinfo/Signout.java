package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/signout")
public class Signout extends HttpServlet {

	public void service( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession s = req.getSession(true);
		s.invalidate();
		res.sendRedirect("/shootmovie/login.jsp");
	}
}
