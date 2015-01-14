package fr.iutinfo;

import java.util.Iterator;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface VideoDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS videos (id INTEGER PRIMARY KEY, titre STRING, description TEXT, dateUpload STRING, url text, realisateur INTEGER, note DOUBLE, compteur INTEGER)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO videos (titre,description,dateUpload,url,realisateur,note,compteur) VALUES (:titre,:description,:dateUpload,:url,:realisateur,'2.5',0)")
	public void insertVideo(@Bind("titre") String titre, @Bind("description") String description, @Bind("dateUpload") String dateUpload, @Bind("url") String url, @Bind("realisateur") int realisateur);
	
	@SqlQuery("SELECT * FROM videos where id=:id")
	public Video getVideo(@Bind("id") int id);
	
	@SqlQuery("SELECT * FROM videos")
	public Iterator<Video> getAllVideo();
	
	@SqlUpdate("DROP TABLE videos")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM IF EXISTS videos where id=:id")
	public void deleteVideo(@Bind("id") int id);
}
