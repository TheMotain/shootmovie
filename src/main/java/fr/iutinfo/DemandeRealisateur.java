package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemandeRealisateur
 */
@WebServlet("/realisateur")
public class DemandeRealisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DevenirRealisateurDao rdao = App.dbi.open(DevenirRealisateurDao.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rdao.createTable();
		HttpSession s = request.getSession(true);
		if (s.getAttribute("login") == null) {
			response.sendRedirect("index.jsp");
		} else {
			rdao.createTable();
			String lien = (String) request.getParameter("link");
			String login = (String) s.getAttribute("login");
			rdao.insertDemande(login, lien);
			response.sendRedirect("home");
		}
	}

}
