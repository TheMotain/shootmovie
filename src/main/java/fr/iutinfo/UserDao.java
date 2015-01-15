package fr.iutinfo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface UserDao {
	@SqlUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, pseudo STRING, password STRING, email STRING, type STRING, dateInscription STRING)")
	public void createTable();
	
	@SqlUpdate("INSERT INTO users (pseudo,password,type,dateInscription) VALUES (:pseudo,:password,'standard user',:date)")
	public void insertUser(@Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("date") String date);
	
	@SqlUpdate("INSERT INTO users (pseudo,password,email,type,dateInscription) VALUES(:pseudo,:password,:email,:type,:dateInscription)")
	public void insertUser(@Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("email") String email, @Bind("type") String type, @Bind("dateInscription") String dateInscription);
	
	@SqlUpdate("UPDATE users SET pseudo=:pseudo,password=:password,email=:email,type=:type,dateInscription:dateInscription) where id=:id")
	public void updateUser(@Bind("id") int id, @Bind("pseudo") String pseudo, @Bind("password") String password, @Bind("email") String email, @Bind("type") String type, @Bind("dateInscription") String dateInscription);
	
	@SqlQuery("SELECT * FROM users WHERE pseudo=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public User selectUser(@Bind("pseudo") String pseudo , @Bind("password") String password);
	
	@SqlQuery("SELECT type FROM users WHERE pseudo=:pseudo")
	public String selectType(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo")
	public String selectPseudo(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo and password=:password")
	public String selectPseudo(@Bind("pseudo") String pseudo, @Bind("password") String password);
	
	@SqlUpdate("DROP TABLE IF EXISTS users")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM users WHERE id=:id")
	public void deleteUser(@Bind("id") int id);
}
