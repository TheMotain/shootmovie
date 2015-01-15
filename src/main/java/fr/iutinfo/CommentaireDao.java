package fr.iutinfo;

import java.util.Iterator;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CommentaireDao {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS commentaires (id_c INTEGER PRIMARY KEY, foreign_key_id_v INTEGER, foreign_key_id_u INTEGER, commentaire TEXT, FOREIGN KEY(foreign_key_id_v) REFERENCES videos(id), FOREIGN KEY(foreign_key_id_u) REFERENCES users(id)))")
	public void createTable();
	
	@SqlUpdate("INSERT INTO commentaires (id_c,id_v,id_u,commentaire) VALUES (:id_c,:id_v,:id_u,:commentaire)")
	public void insertVideo(@Bind("id_c") int id_c, @Bind("id_v") int id_v, @Bind("id_u") int id_u, @Bind("commentaire") String commentaire);

	@SqlQuery("SELECT * FROM commentaires where id_c=:id_c")
	public Commentaire getCommentaire(@Bind("id_c") int id_c);
	
	@SqlQuery("SELECT * FROM commentaires where id_v=:id_v")
	public Commentaire getCommentaireByVideo(@Bind("id_v") int id_v);
	
	@SqlQuery("SELECT * FROM commentaires where id_u=:id_u")
	public Commentaire getCommentaireByUser(@Bind("id_u") int id_u);
	
	@SqlQuery("SELECT * FROM commentaires")
	public Iterator<Commentaire> getAllCommentaire();
	
	@SqlUpdate("DROP TABLE COMMMENTAIRES")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM IF EXISTS commentaires where id_c=:id_c")
	public void deleteCommentaire(@Bind("id_c") int id_c);
}
