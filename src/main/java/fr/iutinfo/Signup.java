package fr.iutinfo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class Signup extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		userdao.createTable();
		String login = req.getParameter("login");
		String password = req.getParameter("mdp");
		String user = userdao.selectPseudo(login);
		if(user == null){
			userdao.insertUser(login, password);
			res.sendRedirect("index.html");
		}
		else
			res.sendRedirect("inscription.html");
	}
}
