package fr.iutinfo;

public class Profil {

	private int id;
	private int id_utilisateur;
	private String lien_background;
	private String lien_avatar;
	

	public Profil(int id, int id_utilisateur, String lien_background, String lien_avatar) {
		this.id=id;
		this.id_utilisateur=id_utilisateur;
		this.lien_background=lien_background;
		this.lien_avatar=lien_avatar;
		
	}
	
	public Profil () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getLien_background() {
		return lien_background;
	}

	public void setLien_background(String lien_background) {
		this.lien_background = lien_background;
	}

	public String getLien_avatar() {
		return lien_avatar;
	}

	public void setLien_avatar(String lien_avatar) {
		this.lien_avatar = lien_avatar;
	}
	
	
}
