package fr.iutinfo;

import java.io.IOException;
import java.util.Iterator;

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
	private static VideoDao vdao = App.dbi.open(VideoDao.class);
	private static ProfilDao pdao = App.dbi.open(ProfilDao.class);
	
	/*
	 * Ceci est MON profil.
	 * Implique qu'on soit connecté.
	 * Différent d'une page de profil standard. Ex : ajout d'un bouton "Modifier" qui envoi sur la page de modification du profil.
	 */
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		vdao.createTable();
 		userdao.createTable();
 		pdao.createTable();
 		
		HttpSession s = req.getSession(true);
		User user = userdao.selectUserbyPseudo((String) s.getAttribute("login"));
		if(user == null){
			res.sendRedirect("/");
		}
		
		String avatarLink = pdao.getProfil((int) s.getAttribute("id")).getLien_avatar();
		String pseudo = user.getPseudo();
		String email = user.getEmail();
		String dateInscription = user.getDateInscription();
		String type = user.getType();
		String des = user.getDes();
		String fb = user.getFb();
		String twitter = user.getTwitter();
		String gplus = user.getGplus();
		
		req.setAttribute("avatar", avatarLink);
		req.setAttribute("name", pseudo);
		req.setAttribute("email", email);
		req.setAttribute("dateInscription", dateInscription);
		req.setAttribute("type", type);
		if(!(userdao.selectDes(pseudo)==null)){
			req.setAttribute("des", des);
		} else {
			req.setAttribute("des", "");
		}
		
		if(!(userdao.selectFb(pseudo)==null)){
			req.setAttribute("facebook", fb);
		} else {
			req.setAttribute("facebook", "");
		}
		
		if(!(userdao.selectTwitter(pseudo)==null)){
			req.setAttribute("twitter", twitter);
		} else {
			req.setAttribute("twitter", "");
		}
		
		if(!(userdao.selectGplus(pseudo)==null)){
			req.setAttribute("gplus", gplus);
		} else {
			req.setAttribute("gplus", "");
		}
		
		this.getServletContext().getRequestDispatcher("/dumpPage.jsp").forward(req, res);
		
	}

}
