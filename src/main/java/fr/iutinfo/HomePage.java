package fr.iutinfo;

import java.io.IOException;

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
	private static UserDao userdao = App.dbi.open(UserDao.class);

	public void service( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		if(s.getAttribute("logged") != null) response.sendRedirect("/index.jsp");
		
		String user = userdao.selectType((String) s.getAttribute("login"));
		request.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/homeSpectateur.jsp").forward(request, response);
	}
}
