package fr.iutinfo;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/home")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoDao vdao = App.dbi.open(VideoDao.class);
	private static UserDao udao = App.dbi.open(UserDao.class);

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		vdao.createTable();
		udao.createTable();
		HttpSession s = request.getSession(true);
		String login = (String) s.getAttribute("login");
		if (login == null) {
			response.sendRedirect("login.jsp?connexion");
		} else {
			if(udao.selectType(login).equals("realisator")){
				Iterator<Video> videosIterator = vdao.getPseudoVideo(login);
				String videos = "";
				while(videosIterator.hasNext()){
					Video v = videosIterator.next();
					videos += v.getId()+ "§" +v.getTitre() + "§" + v.getRealisateur() + "§" + v.getDateUpload();
					videos += "£";
				}
				request.setAttribute("videos", videos);
				this.getServletContext().getRequestDispatcher("/homeRealisateur.jsp").forward(request, response);
			} else {
				Iterator<Video> videosIterator = vdao.getLastVideo();
				String videos = "";
				while(videosIterator.hasNext()){
					Video v = videosIterator.next();
					videos += v.getId()+ "§" +v.getTitre() + "§" + v.getRealisateur() + "§" + v.getDateUpload();
					videos += "£";
				}
				request.setAttribute("videos", videos);
				this.getServletContext().getRequestDispatcher("/homeSpectateur.jsp").forward(request, response);
			}
		}
	}
}
