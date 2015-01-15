package fr.iutinfo;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setCommentaire")
public class SetCommentaire extends HttpServlet{
	public static CommentaireDao commentairedao = App.dbi.open(CommentaireDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession s = req.getSession();
		
		//commentairedao.insertCommentaire(req.getParameter("id"), s.getAttribute("id"), req.getParameter("com"), date, heure)
	}
}
