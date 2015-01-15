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
	private static UserDao userdao = App.dbi.open(UserDao.class);

	public void service( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		userdao.createTable();
		HttpSession s = req.getSession(true);
		if(s.getAttribute("login") != null){
			res.sendRedirect("/home");
		} else {
			String login = req.getParameter("login");
			String password = req.getParameter("mdp");
			User user = userdao.selectUser(login, password);
			if(user != null){
				
				s.setAttribute("login", user.getPseudo());
				s.setAttribute("id", user.getId());
				s.setAttribute("logged", true);
				res.sendRedirect("home");
			}
			else
				res.sendRedirect("login.jsp?error");
		}
	}
}
