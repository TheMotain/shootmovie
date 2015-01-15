package fr.iutinfo;

import java.util.Iterator;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface VideoDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS videos (id INTEGER PRIMARY KEY, titre STRING, description TEXT, dateUpload STRING, url TEXT, realisateur TEXT, note DOUBLE, compteur INTEGER)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO videos (titre,description,dateUpload,url,realisateur,note,compteur) VALUES (:titre,:description,:dateUpload,:url,:realisateur,'2.5',0)")
	public void insertVideo(@Bind("titre") String titre, @Bind("description") String description, @Bind("dateUpload") String dateUpload, @Bind("url") String url, @Bind("realisateur") String realisateur);
	
	@SqlQuery("SELECT * FROM videos where lien=:lien")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Video getVideoByLink(@Bind("lien") String lien);
	
	@SqlQuery("SELECT * FROM videos where id=:id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Video getVideo(@Bind("id") int id);
	
	@SqlQuery("SELECT * FROM videos")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getAllVideo();
	
	@SqlQuery("SELECT * FROM videos where realisateur=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getPseudoVideo(@Bind("pseudo") String pseudo);
	
	@SqlUpdate("DROP TABLE videos")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM IF EXISTS videos where id=:id")
	public void deleteVideo(@Bind("id") int id);
}
