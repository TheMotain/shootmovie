package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/tempProfil")
public class tempProfil extends HttpServlet {
	private static UserDao userdao = App.dbi.open(UserDao.class);

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		userdao.createTable();

		HttpSession s = req.getSession(true);
		User user = userdao
				.selectUserbyPseudo((String) s.getAttribute("login"));

		if (user == null) {
			res.sendRedirect("/");
		}
		int id = user.getId();

		// Pour garder les anciennes infos dans les champs

		String pseudo = user.getPseudo();
		String emailR = user.getEmail();
		String dateInscription = user.getDateInscription();
		String type = user.getType();
		String desR = user.getDes();
		String fb = user.getFb();
		String twitterR = user.getTwitter();
		String gplusR = user.getGplus();

		req.setAttribute("name", pseudo);
		req.setAttribute("email", emailR);
		req.setAttribute("dateInscription", dateInscription);
		req.setAttribute("type", type);

		if (!(userdao.selectDes(pseudo) == null)) {
			req.setAttribute("des", desR);
		} else {
			req.setAttribute("des", "");
		}

		if (!(userdao.selectFb(pseudo) == null)) {
			req.setAttribute("facebook", fb);
		} else {
			req.setAttribute("facebook", "");
		}

		if (!(userdao.selectTwitter(pseudo) == null)) {
			req.setAttribute("twitter", twitterR);
		} else {
			req.setAttribute("twitter", "");
		}

		if (!(userdao.selectGplus(pseudo) == null)) {
			req.setAttribute("gplus", gplusR);
		} else {
			req.setAttribute("gplus", "");
		}

		this.getServletContext().getRequestDispatcher("/modifProfil.jsp")
				.forward(req, res);

	}

}
