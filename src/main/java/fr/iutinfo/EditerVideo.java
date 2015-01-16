package fr.iutinfo;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/editVideo")
public class EditerVideo extends HttpServlet{
	public static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		videodao.createTable();
		HttpSession s = req.getSession(true);
		
		Video video =videodao.getVideo(Integer.parseInt(req.getParameter("id")));
		if(video != null){
			String titre = video.getTitre();
			String description = video.getDescription();
			
			req.setAttribute("titre", titre);
			req.setAttribute("description", description);
			
			req.getServletContext().getRequestDispatcher("/editVideo.jsp").forward(req, res);
		}
	}
}
