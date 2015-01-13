package fr.iutinfo;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		try {
			Bdd.connexion();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
