package fr.iutinfo;

import java.util.Iterator;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface DevenirRealisateurDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS demandesReal (id INTEGER PRIMARY KEY, pseudo STRING, lien TEXT)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO demandesReal (pseudo,lien) VALUES (:pseudo,:lien)")
	public void insertDemande(@Bind("pseudo") String pseudo, @Bind("lien") String lien);
	
	@SqlQuery("SELECT * FROM demandesReal where pseudo=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public DevenirRealisateur getDemandeByPseudo(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT * FROM demandesReal where id=:id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public DevenirRealisateur getDemandeById(@Bind("id") int id);
	
	@SqlQuery("SELECT * FROM demandesReal")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<DevenirRealisateur> getAllDemandes();
	
	@SqlQuery("SELECT * FROM demandesReal ORDER BY id DESC")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<DevenirRealisateur> getLastDemandes();
	
	@SqlUpdate("DROP TABLE demandesReal")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM demandesReal where id=:id")
	public void deleteDemande(@Bind("id") int id);
}
