package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service( HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
	}

}
