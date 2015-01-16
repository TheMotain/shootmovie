package fr.iutinfo;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjouterVideo
 */
@WebServlet("/addVideo")
public class AjouterVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDao vdao = App.dbi.open(VideoDao.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/addVideo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vdao.createTable();
		HttpSession s = request.getSession(true);
		
		String lien = request.getParameter("lien");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String realisateur = (String) s.getAttribute("login");
		
		Video v = vdao.getVideoByLink(lien);
		if(v == null){
			
			Calendar cal = Calendar.getInstance();
			String day;
			String month;
			String year = "" + cal.get(Calendar.YEAR);
			if(cal.get(Calendar.DAY_OF_MONTH) < 10)
				day = 0 + "" + cal.get(Calendar.DAY_OF_MONTH);
			else
				day = cal.get(Calendar.DAY_OF_MONTH) + "";
			if(cal.get(Calendar.MONTH)+1 < 10)
				month = 0 + "" + (cal.get(Calendar.MONTH) + 1);
			else
				month = cal.get(Calendar.MONTH) + "";
			String date = day+"/"+month+"/"+year;
			
			vdao.insertVideo(titre, description, date, lien, realisateur);
			
			Video newVideo = vdao.getVideoByLink(lien);
			
			response.sendRedirect("video?id="+newVideo.getId());
		}
	}
}
