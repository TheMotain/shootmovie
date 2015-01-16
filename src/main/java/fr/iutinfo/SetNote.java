package fr.iutinfo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/setNote")
public class SetNote extends HttpServlet{
	private static NoteDao notedao = App.dbi.open(NoteDao.class);
	private static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		notedao.createTable();
		videodao.createTable();
		videodao.decrementVue(Integer.parseInt(req.getParameter("id")));
		Integer id = notedao.getID(Integer.parseInt(req.getParameter("id")),(Integer) req.getSession().getAttribute("id"));
		if(id != null){
			notedao.update(id,Integer.parseInt(req.getParameter("note")));
			videodao.updateNote(Integer.parseInt(req.getParameter("id")),notedao.getMoyenne(Integer.parseInt(req.getParameter("id"))));
		}
		else{
			notedao.insertNote(Integer.parseInt(req.getParameter("id")),(Integer) req.getSession().getAttribute("id"),Integer.parseInt(req.getParameter("note")));
			videodao.updateNote(Integer.parseInt(req.getParameter("id")),notedao.getMoyenne(Integer.parseInt(req.getParameter("id"))));
		}
		res.sendRedirect("/shootmovie/video?id="+req.getParameter("id"));
	}
}
