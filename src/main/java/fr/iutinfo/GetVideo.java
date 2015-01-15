package fr.iutinfo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/video")
public class GetVideo extends HttpServlet{
	private static VideoDao videodao = App.dbi.open(VideoDao.class);
	private static CommentaireDao commentairedoa = App.dbi.open(CommentaireDao.class);
	private static UserDao userdao = App.dbi.open(UserDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		videodao.createTable();
		commentairedoa.createTable();
		userdao.createTable();
		
		Video video = videodao.getVideo(Integer.parseInt(req.getParameter("id")));
		
		req.setAttribute("url", video.getUrl());
		req.setAttribute("titre", video.getTitre());
		req.setAttribute("realisateur", video.getRealisateur());
		req.setAttribute("description", video.getDescription());
		req.setAttribute("date", video.getDateUpload());
		req.setAttribute("note", video.getNote());
		
		Iterator<Commentaire> it = commentairedoa.getAllCommentaireDescLimit(5);
		String commentaire = "";
		Commentaire tmp;
		while(it.hasNext()){
			tmp = it.next();
			commentaire += userdao.selectPseudo(tmp.getId_utilisateur());
		}
		req.setAttribute("commentaires", commentaire);
		
		req.getServletContext().getRequestDispatcher("/video.jsp").forward(req, res);
	}
}
