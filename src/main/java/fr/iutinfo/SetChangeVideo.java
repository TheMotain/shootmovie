package fr.iutinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/setchangevideo")
public class SetChangeVideo extends HttpServlet{
	public static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		videodao.createTable();
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
		System.out.println(description);
		int id = Integer.parseInt(req.getParameter("id"));
		
		videodao.updateData(id,titre,description);
		res.sendRedirect("/video?id="+id);
	}
}
