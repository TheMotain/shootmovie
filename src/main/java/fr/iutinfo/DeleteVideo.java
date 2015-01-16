package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteVideo
 */
@WebServlet("/deleteVideo")
public class DeleteVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDao vdao = App.dbi.open(VideoDao.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idVideo = request.getParameter("id");
		int id = Integer.parseInt(idVideo);
		vdao.deleteVideo(id);
		response.sendRedirect("moderation");
	}

}
