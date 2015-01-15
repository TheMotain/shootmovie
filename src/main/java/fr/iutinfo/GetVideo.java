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
		Video video = videodao.getVideo(1);
		System.out.println(video.getUrl());
		req.setAttribute("url", video.getUrl());
		req.getServletContext().getRequestDispatcher("/video.jsp").forward(req, res);
	}
}
