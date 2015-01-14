package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY AUTOINCREMENT, pseudo STRING, password STRING, email STRING, dateInscription STRING)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO users (pseudo,password,email,dateInscription) VALUES(:pseudo,:password,:email,:dateInscription)")
	public void insertUser(@Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("email") String email, @Bind("dateInscription") String dateInscription);
	
	@SqlUpdate("INSERT INTO users (pseudo,password) VALUES(:pseudo,:password)")
	public void insertUser(@Bind("pseudo") String pseudo, @Bind("password") String password);
	
	@SqlUpdate("UPDATE users SET pseudo=:pseudo,password=:password,email=:email,dateInscription:dateInscription) where id=:id")
	public void updateUser(@Bind("id") int id, @Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("email") String email, @Bind("dateInscription") String dateInscription);
	
	
	@SqlQuery("SELECT * FROM users WHERE pseudo=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public User selectUser(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo")
	public String selectPseudo(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo and password=:password")
	public String selectPseudo(@Bind("pseudo") String pseudo, @Bind("password") String password);
	
	@SqlUpdate("DROP TABLE IF EXISTS users")
	public void dropTable();
}
