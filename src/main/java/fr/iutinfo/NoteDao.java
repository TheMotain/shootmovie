package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface NoteDao {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS notes (id INTEGER PRIMARY KEY, id_video INTEGER, id_utilisateur INTEGER, note INTEGER, FOREIGN KEY(id_video) REFERENCES videos(id), FOREIGN KEY(id_utilisateur) REFERENCES users(id))")
	public void createTable();
	
	@SqlQuery("SELECT id FROM notes WHERE id_video=:id_video AND id_utilisateur=:id_utilisateur")
	public Integer getID(@Bind("id_video") int id_video, @Bind("id_utilisateur") int id_utilisateur);
	
	@SqlUpdate("DROP TABLE notes")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM notes WHERE id=:id")
	public void deleteVote(@Bind("id") int id);

	@SqlUpdate("UPDATE notes SET note=:note WHERE id=:id")
	public void update(@Bind("id")int id, @Bind("note")int note);

	@SqlUpdate("INSERT INTO notes (id_video,id_utilisateur,note) VALUES (:id_video,:id_utilisateur,:note)")
	public void insertNote(@Bind("id_video")int id_video,@Bind("id_utilisateur") int id_utilisateur, @Bind("note") int note);
	
	@SqlQuery("SELECT AVG(note) FROM notes WHERE id_video=:id_video")
	public double getMoyenne(@Bind("id_video") int id_video);

	@SqlQuery("SELECT note FROM notes WHERE id=:id")
	public Integer getNote(@Bind("id") int id);
}
