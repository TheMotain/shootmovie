package fr.iutinfo;

import java.util.Iterator;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ProfilDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS profils (id INTEGER PRIMARY KEY, id_utilisateur INTEGER, lien_background TEXT, lien_avatar TEXT, des TEXT, fb TEXT, twitter TEXT, gplus TEXT, FOREIGN KEY(id_utilisateur) REFERENCES users(id)))")
	public void createTable();
	
	@SqlUpdate("INSERT INTO profils (id,id_utilisateur,lien_background,lien_avatar) VALUES (:id,:id_utilisateur,:lien_background,:lien_avatar)")
	public void insertProfil(@Bind("id") int id, @Bind("id_utilisateur") int id_utilisateur, @Bind("lien_background") String lien_background, @Bind("lien_avatar") String lien_avatar);
	
	@SqlUpdate("INSERT INTO profils (id,id_utilisateur,des) VALUES (:id,:id_utilisateur,:des)")
	public void insertProfilDes(@Bind("id") int id, @Bind("id_utilisateur") int id_utilisateur, @Bind("des") String des);
	
	@SqlUpdate("INSERT INTO profils (id,id_utilisateur,des) VALUES (:id,:id_utilisateur,:fb)")
	public void insertProfilFb(@Bind("id") int id, @Bind("id_utilisateur") int id_utilisateur, @Bind("fb") String fb);
	
	@SqlUpdate("INSERT INTO profils (id,id_utilisateur,des) VALUES (:id,:id_utilisateur,:twitter)")
	public void insertProfilTwitter(@Bind("id") int id, @Bind("id_utilisateur") int id_utilisateur, @Bind("twitter") String twitter);
	
	@SqlUpdate("INSERT INTO profils (id,id_utilisateur,des) VALUES (:id,:id_utilisateur,:gplus)")
	public void insertProfilGplus(@Bind("id") int id, @Bind("id_utilisateur") int id_utilisateur, @Bind("gplus") String gplus);
	
	@SqlQuery("SELECT * FROM profils where id=:id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Profil getProfil(@Bind("id") int id);
	
	@SqlQuery("SELECT * FROM commentaires where id_utilisateur=:id_utilisateur")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Profil getProfilByUser(@Bind("id_utilisateur") int id_utilisateur);
	
	@SqlQuery("SELECT * FROM profils")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<Profil> getAllProfil();
	
	@SqlUpdate("DROP TABLE profils")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM IF EXISTS profils where id=:id")
	public void deleteVideo(@Bind("id") int id);
}

