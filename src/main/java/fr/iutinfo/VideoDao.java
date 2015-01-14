package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface VideoDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS videos (id INTEGER PRIMARY KEY, titre STRING, description TEXT, dateUpload STRING, url text, realisateur INTEGER, note DOUBLE, compteur INTEGER)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO videos (titre,description,dateUpload,url,realisateur,note,compteur) VALUES (:titre,:description,:dateUpload,:url,:realisateur,'2.5',0)")
	public void insertVideo(@Bind("titre") String titre, @Bind("description") String description, @Bind("dateUpload") String dateUpload, @Bind("url") String url, @Bind("realisateur") int realisateur);
	
	
}
