package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/myProfil")
public class myProfil extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	/*
	 * Ceci est MON profil.
	 * Implique qu'on soit connecté.
	 * Différent d'une page de profil standard. Ex : ajout d'un bouton "Modifier" qui envoi sur la page de modification du profil.
	 */
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		userdao.createTable();
		
		HttpSession s = req.getSession(true);
		User user = userdao.selectUserbyPseudo((String) s.getAttribute("login"));
		if(user == null){
			res.sendRedirect("/");
		}
		
		// des, facebook, twitter et gplus à mettre dans un table si possible
		String des = "*Description*";
		String fb = "*Facebook*";
		String twitter = "*Twitter*";
		String gplus = "*Google+*";
		
		String pseudo = user.getPseudo();
		String email = user.getEmail();
		String dateInscription = user.getDateInscription();
		String type = user.getType();
		
		req.setAttribute("name", pseudo);
		req.setAttribute("email", email);
		req.setAttribute("dateInscription", dateInscription);
		req.setAttribute("type", type);
		req.setAttribute("des", des);
		req.setAttribute("facebook", fb);
		req.setAttribute("twitter", twitter);
		req.setAttribute("gplus", gplus);
		
		
		this.getServletContext().getRequestDispatcher("/dumpPage.jsp").forward(req, res);
		
	}

}
