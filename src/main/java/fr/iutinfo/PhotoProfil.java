package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PhotoProfil
 */
@WebServlet("/changeAvatar")
public class PhotoProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProfilDao pdao = App.dbi.open(ProfilDao.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		if(s.getAttribute("login") == null){
			response.sendRedirect("signin");
		} else {
			this.getServletContext().getRequestDispatcher("/ProfilImage.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		String lien = request.getParameter("avatar");
		
		
		pdao.createTable();
		pdao.updateAvatar((int) s.getAttribute("id"), lien);
		
		response.sendRedirect("myProfil");
	}

}
