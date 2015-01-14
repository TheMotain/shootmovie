package fr.iutinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class Signup extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		try {
			userdao.dropTable();
			userdao.createTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
		String login = req.getParameter("login");
		String password = req.getParameter("mdp");
		PrintWriter out = res.getWriter();
		out.println("<h1>"+login+" / "+password+"</h1>");
		String user = userdao.selectPseudo(login);
		out.println(user);
		if(user == null)
			userdao.insertUser(login, password);
	}
}
