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
	
	@SqlQuery("SELECT * FROM videos where url=:url")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Video getVideoByLink(@Bind("url") String url);
	
	@SqlQuery("SELECT * FROM videos where id=:id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Video getVideo(@Bind("id") int id);
	
	@SqlQuery("SELECT * FROM videos")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getAllVideo();
	
	@SqlQuery("SELECT * FROM videos where titre=:titre")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getAllVideoTitre(@Bind("titre") String titre);
	
	@SqlQuery("SELECT * FROM videos ORDER BY id DESC")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getLastVideo();
	
	@SqlQuery("SELECT * FROM videos where realisateur=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Video> getPseudoVideo(@Bind("pseudo") String pseudo);
	
	@SqlUpdate("DROP TABLE videos")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM videos where id=:id")
	public void deleteVideo(@Bind("id") int id);

	@SqlUpdate("UPDATE videos SET note=:note WHERE id=:id")
	public void updateNote(@Bind("id") int id, @Bind("note")double note);

	@SqlUpdate("UPDATE videos SET compteur=(SELECT compteur + 1 FROM videos WHERE id=:id) WHERE id=:id")
	public void incrementVue(@Bind("id") int id);
	
	@SqlUpdate("UPDATE videos SET compteur=(SELECT compteur - 1 FROM videos WHERE id=:id) WHERE id=:id")
	public void decrementVue(@Bind("id") int id);

	@SqlUpdate("UPDATE videos SET titre=:titre, description=:description WHERE id=:id")
	public void updateData(@Bind("id") int id, @Bind("titre") String titre, @Bind("description") String description);
}
