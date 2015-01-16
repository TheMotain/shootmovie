package fr.iutinfo;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/setCommentaire")
public class SetCommentaire extends HttpServlet{
	public static CommentaireDao commentairedao = App.dbi.open(CommentaireDao.class);
	public static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		videodao.createTable();
		commentairedao.createTable();
		videodao.decrementVue(Integer.parseInt(req.getParameter("id")));
		
		HttpSession session = req.getSession();
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
		String h;
		String m;
		String s;
		if(cal.get(Calendar.HOUR_OF_DAY) < 10)
			h = 0 + "" + cal.get(Calendar.HOUR_OF_DAY);
		else
			h = "" + cal.get(Calendar.HOUR_OF_DAY);
		if(cal.get(Calendar.MINUTE) < 10)
			m = 0 + "" + cal.get(Calendar.MINUTE);
		else
			m = "" + cal.get(Calendar.MINUTE);
		if(cal.get(Calendar.SECOND) < 10)
			s = 0 + "" + cal.get(Calendar.SECOND);
		else
			s = "" + cal.get(Calendar.SECOND);
		String heure = h + ":" + m + ":" + s;
		commentairedao.insertCommentaire(Integer.parseInt(req.getParameter("id")), (Integer) session.getAttribute("id"), req.getParameter("comm"), date, heure);
		res.sendRedirect("/video?id="+req.getParameter("id"));
	}
}
