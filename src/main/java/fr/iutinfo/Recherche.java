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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/Rechercher.jsp")
				.forward(request, response);
		vdao.createTable();

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String recherche = request.getParameter("rechercher");

		if (recherche != null) {
			Iterator<Video> it = vdao.getAllVideoTitre(recherche);
			out.println("<!doctype html>");
			out.println("<head><title>recherche</title></head><body>");

			while (it.hasNext()) {
				out.println("<p> " + it.next().getTitre() + "</p>");
			}

			out.println("</body></html>");

		}

	}
}
