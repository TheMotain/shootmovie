package fr.iutinfo;

public class User {
	private int id;
	private String pseudo;
	private String password;
	private String email;
	private String type;
	private String dateInscription;

	public User(int id, String pseudo, String password, String email) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
		this.type = "standard user";
		this.dateInscription = "00/00/0000";
	}
	
	public User(int id, String pseudo, String password, String email, String type, String dateInscription){
		this(id,pseudo,password,email);
		this.type = type;
		this.dateInscription = dateInscription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
