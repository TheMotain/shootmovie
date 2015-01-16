package fr.iutinfo;

public class DevenirRealisateur {
	
	private int id;
	private String pseudo;
	private String lien;
	
	public DevenirRealisateur(String pseudo, String lien){
		this.pseudo = pseudo;
		this.lien = lien;
	}
	
	public DevenirRealisateur(){
		
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

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}
	
	

}
