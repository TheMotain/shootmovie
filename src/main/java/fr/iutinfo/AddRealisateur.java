package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRealisateur
 */
@WebServlet("/addRealisateur")
public class AddRealisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DevenirRealisateurDao rdao = App.dbi.open(DevenirRealisateurDao.class);
	private static UserDao userdao = App.dbi.open(UserDao.class);

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rdao.createTable();
		userdao.createTable();
		int idDemande = Integer.parseInt(request.getParameter("id"));
		int success = Integer.parseInt(request.getParameter("success"));
		int idUser = userdao.selectUserbyPseudo(rdao.getDemandeById(idDemande).getPseudo()).getId();
		if(success == 1){
			userdao.updateUserType(idUser, "realisator");
		}
		rdao.deleteDemande(idDemande);
		response.sendRedirect("home");
	}
}
