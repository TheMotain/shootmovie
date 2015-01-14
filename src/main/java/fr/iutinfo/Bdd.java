package fr.iutinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {

	private static Connection con;

	/*protected static void connexion() throws ClassNotFoundException,
	SQLException*/
	public static void main(String[]args) throws ClassNotFoundException, SQLException{
		if (con == null) {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:ShootMovie");
			Statement statement = con.createStatement();

			/*statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, pseudo STRING, password STRING, email STRING, dateInscription STRING)");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS videos (id SERIAL PRIMARY KEY, titre STRING, description TEXT, dateUpload STRING, realisateur INTEGER, note DOUBLE)");
			*/
			ResultSet rs=statement.executeQuery("Select * from users");
			ResultSetMetaData rsmd = rs.getMetaData();

			for(int i=1;i<=rsmd.getColumnCount();++i){
				System.out.println(rs.getString(i));
			}
		}
	}

	protected static void deconnexion() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = null;
	}


}
