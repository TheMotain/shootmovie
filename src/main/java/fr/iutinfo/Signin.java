package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/signin")
public class Signin extends HttpServlet {
	public void service( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("login").equals("admin") && req.getParameter("mdp").equals("admin")){
			HttpSession s = req.getSession(true);
			s.setAttribute("login", req.getParameter("login"));
			res.sendRedirect("index.html");
		}
		else
			res.sendRedirect("login.html");
	}
}
