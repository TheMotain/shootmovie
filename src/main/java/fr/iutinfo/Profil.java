package fr.iutinfo;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
@WebServlet("/servlet/Profil")
public class Profil extends HttpServlet
{

	public void service( HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
			{
		//	try{
		String nom=req.getParameter("name");


		PrintWriter out = res.getWriter();
		/*	res.setContentType("text/html");
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://psqlserv/n3p1";
			String name="migank";
			String pass="moi";
			Connection con=DriverManager.getConnection(url,name,pass);
		 */

		out.println("<!doctype html>");
		out.println("<head><title>page login</title></head><body>");
		out.println("<p>");

		out.println("</p>");
		out.println("</html>");






		//con.close();

			}
	/*
		catch(SQLException sq){
			sq.printStackTrace();
			System.out.println("probleme au niveau de la base de donnees");

		}
		catch(ClassNotFoundException cnf){
			System.out.println("probleme classe mere oups ");
		}
			}*/
}

