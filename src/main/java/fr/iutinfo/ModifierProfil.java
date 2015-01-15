package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/modifierProfil")
public class ModifierProfil extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		userdao.createTable();
		
		HttpSession s = req.getSession(true);
		User user = userdao.selectUserbyPseudo((String) s.getAttribute("login"));
		
		if(user==null){
			res.sendRedirect("/");
		}
		int id = user.getId();
		
		String change = (String) req.getParameter("change");
		String newPseudo = req.getParameter("pseudo");
		String mdp = req.getParameter("mdp");
		String mdpVerif = req.getParameter("mdpVerif");
		String email = req.getParameter("email");
		String des = req.getParameter("des");
		String facebook = req.getParameter("fb");
		String twitter = req.getParameter("twitter");
		String gplus = req.getParameter("gplus");
		
		if(change != null && change.equals("1")){
			
			System.out.println("test");
			
			if(!newPseudo.isEmpty()){
				
				user.setPseudo(newPseudo);
				userdao.updateUserPseudo(id, newPseudo);
				
			}
			
			if(!mdp.isEmpty()){
				if(mdpVerif != null && mdp.equals(mdpVerif)){
					user.setMdp(mdpVerif);
					userdao.updateUserPassword(id, mdpVerif);
				} else {
					res.sendRedirect("errorMdp.jsp");
				}
			}
			
			if(!email.isEmpty()){
				user.setEmail(email);
				userdao.updateUserEmail(id, email);
			}
			
			if(!des.isEmpty()){
				s.setAttribute("des", des);
			}
			
			if(!facebook.isEmpty()){
				s.setAttribute("facebook", facebook);
			}
			
			if(!twitter.isEmpty()){
				s.setAttribute("twitter", twitter);
			}
			
			if(!gplus.isEmpty()){
				s.setAttribute("gplus", gplus);
			}
			
			s.setAttribute("login", user.getPseudo());
			res.sendRedirect("myProfil");
			
		}
		
		res.sendRedirect("myProfil");
	
		this.getServletContext().getRequestDispatcher("/modifProfil.jsp").forward(req, res);
	}
	
}
