package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet{
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		userdao.createTable();
		
		HttpSession s = req.getSession(true);
		
		if(s.getAttribute("pseudo")==null){
			res.sendRedirect("index.html");
		}else{
			
		}
	
		this.getServletContext().getRequestDispatcher("/modifProfil.jsp").forward(req, res);
	}
	
}
