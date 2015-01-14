package fr.iutinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/signup")
public class Signup extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String login = req.getParameter("login");
		String mdp = req.getParameter("mdp");
		PrintWriter out = res.getWriter();
		out.println("<h1>"+login+" / "+mdp+"</h1>");
		Connection con = null;
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:odbc:ShootMovie");
			PreparedStatement ps = con.prepareStatement("select pseudo form users");
			//ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				out.println(rs.getString(1)+"<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		getServletContext().setInitParameter("dbi", dbi);
		
		getServletContext().getInitParameter("dni");
	}
}
