package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static UserDao userdao = App.dbi.open(UserDao.class);

	public void service( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		userdao.createTable();
		String login = req.getParameter("login");
		String password = req.getParameter("mdp");
		String user = userdao.selectPseudo(login,password);
		if(user != null){
			res.sendRedirect("index.html");
		}
		else
			res.sendRedirect("login.html");
	}
}
