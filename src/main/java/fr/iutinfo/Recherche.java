package fr.iutinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDao vdao = App.dbi.open(VideoDao.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		vdao.createTable();
		
		Iterator<Video> it = vdao.recherche(search);
		String videos = "";
		while(it.hasNext()){
			Video v = it.next();
			videos += v.getId()+ "§" +v.getTitre() + "§" + v.getRealisateur() + "§" + v.getDateUpload();
			videos += "£";
		}
		System.out.println(videos);
		request.setAttribute("videos", videos);
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
	}
}
