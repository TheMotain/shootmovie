package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/video")
public class GetVideo extends HttpServlet{
	private static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		videodao.createTable();
		Video video = videodao.getVideo(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("url", video.getUrl());
		req.setAttribute("titre", video.getTitre());
		req.setAttribute("realisateur", video.getRealisateur());
		req.setAttribute("description", video.getDescription());
		req.setAttribute("date", video.getDateUpload());
		System.out.println(video.getNote());
		req.setAttribute("note", video.getNote());
		req.getServletContext().getRequestDispatcher("/video.jsp").forward(req, res);
	}
}
