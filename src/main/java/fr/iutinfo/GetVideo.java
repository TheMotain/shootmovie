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
	private static NoteDao notedao = App.dbi.open(NoteDao.class);

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		videodao.createTable();
		commentairedoa.createTable();
		userdao.createTable();
		notedao.createTable();

		Video video = videodao.getVideo(Integer.parseInt(req.getParameter("id")));
		video.setCompteur();
		videodao.incrementVue(video.getId());
		
		User realisateur = userdao.selectUserByID(video.getRealisateur());
		
		req.setAttribute("url", video.getUrl());
		req.setAttribute("titre", video.getTitre());
		req.setAttribute("realisateur", video.getRealisateur());
		req.setAttribute("description", video.getDescription());
		req.setAttribute("date", video.getDateUpload());
		req.setAttribute("note", video.getNote());
		req.setAttribute("compteur", video.getCompteur());

		if(req.getSession().getAttribute("logged") != null){
			req.setAttribute("log", 1);
			Integer id = notedao.getID(Integer.parseInt(req.getParameter("id")),(Integer) req.getSession().getAttribute("id"));
			if(id != null){
				req.setAttribute("vote", (Integer)notedao.getNote(id));
			}else
				req.setAttribute("vote", video.getNote());
		}
		else{
			req.setAttribute("log", 0);
		}

		Iterator<Commentaire> it = commentairedoa.getAllCommentaireDescLimit(video.getId(),5);
		String commentaire = "";
		Commentaire tmp;
		while(it.hasNext()){
			tmp = it.next();
			commentaire += userdao.selectPseudo(tmp.getId_utilisateur())+" "+tmp.getCommentaire();
			commentaire += " "+tmp.getDate()+" "+tmp.getHeure();
			if(it.hasNext())
				commentaire += "|";
		}

		req.setAttribute("commentaires", commentaire);

		req.getServletContext().getRequestDispatcher("/video.jsp").forward(req, res);
	}
}
