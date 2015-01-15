package fr.iutinfo;

import java.util.Iterator;

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
	
	@SqlUpdate("UPDATE users SET pseudo=:pseudo where id=:id")
	public void updateUserPseudo(@Bind("id") int id, @Bind("pseudo") String pseudo);
	
	@SqlUpdate("UPDATE users SET password=:password where id=:id")
	public void updateUserPassword(@Bind("id") int id, @Bind("password") String password);
	
	@SqlUpdate("UPDATE users SET email=:email where id=:id")
	public void updateUserEmail(@Bind("id") int id, @Bind("email") String email);
	
	@SqlQuery("SELECT * FROM users WHERE pseudo=:pseudo and password=:password ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public User selectUser(@Bind("pseudo") String pseudo , @Bind("password") String password);
	
	@SqlQuery("SELECT * FROM users WHERE pseudo=:pseudo")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public User selectUserbyPseudo(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT * FROM users ORDER BY id DESC")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Iterator<User> selectLastUsers();
	
	@SqlQuery("SELECT type FROM users WHERE pseudo=:pseudo ")
	public String selectType(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo")
	public String selectPseudo(@Bind("pseudo") String pseudo);
	
	@SqlQuery("SELECT pseudo FROM users WHERE id=:id")
	public String selectPseudo(@Bind("id") int id);
	
	@SqlQuery("SELECT pseudo FROM users WHERE pseudo=:pseudo and password=:password")
	public String selectPseudo(@Bind("pseudo") String pseudo, @Bind("password") String password);
	
	@SqlUpdate("DROP TABLE IF EXISTS users")
	public void dropTable();
	
	@SqlUpdate("DELETE FROM users WHERE id=:id")
	public void deleteUser(@Bind("id") int id);
	
	@SqlUpdate("SELECT id FROM users WHERE pseudo=:pseudo")
	public int selectId(@Bind("pseudo") String pseudo);
}
