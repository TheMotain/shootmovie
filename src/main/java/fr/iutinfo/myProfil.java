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
	//private static UserDao userdao = App.dbi.open(UserDao.class);
	
	/*
	 * Ceci est MON profil.
	 * Implique qu'on soit connecté.
	 * Différent d'une page de profil standard. Ex : ajout d'un bouton "Modifier" qui envoi sur la page de modification du profil.
	 */
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		/*
		 * this.getServletContext().getRequestDispatcher("dumpPage.jsp").forward(req, res);
		 *  ^^^^
		 * Ligne à virer du commentaire si on souhaite modifier la dumpPage en profil personnel (avec SON pseudo, SON email...etc)
		 * A faire. 
		 */
		
		/*userdao.createTable();
		
		HttpSession s = req.getSession(true);
		User user = userdao.selectUser((String) s.getAttribute("pseudo"));
		if(user == null){
			res.sendRedirect("index.html");
		}
		
		String pseudo = user.getPseudo();
		String email = user.getEmail();
		String dateInscription = user.getDateInscription();
		String type = user.getType();*/
		
		req.setAttribute("name", "Motain");
		this.getServletContext().getRequestDispatcher("/dumpPage.jsp").forward(req, res);
		
	}

}
