package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/changeBaniere")
public class PhotoBaniere extends HttpServlet{
	protected static ProfilDao profildao = App.dbi.open(ProfilDao.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		if(s.getAttribute("login") == null)
			response.sendRedirect("singin");
		else
			request.getServletContext().getRequestDispatcher("/ProfilImage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		profildao.createTable();
		HttpSession s = request.getSession(true);
		String url = request.getParameter("baniere");
		int id = (int) s.getAttribute("id");
		
		profildao.updateBanniere(id, url);
		response.sendRedirect("home");
	}
}
