package fr.iutinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {

	private static Connection con;

	protected static void connexion() throws ClassNotFoundException,
			SQLException {
		if (con == null) {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:3DViewer");
			Statement statement = con.createStatement();

			statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS modele (id SERIAL PRIMARY KEY, name STRING, path STRING, description STRING, keywords STRING, date_ajout DATETIME, nbPoints INTEGER, nbSegments INTEGER, nbFaces INTEGER)");
		}
	}

	protected static void deconnexion() throws SQLException {
		if (con != null) {
			con.close();
		}
		con = null;
	}

}
