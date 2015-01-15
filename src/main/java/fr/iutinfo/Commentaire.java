package fr.iutinfo;

public class Commentaire {
	
	private int id;
	private int id_video;
	private int id_utilisateur;
	private String commentaire;
	private String date;
	private String heure;
	
	
	public Commentaire(int id, int id_video, int id_utilisateur, String commentaire, String date, String heure) {
		this.id=id;
		this.id_video=id_video;
		this.id_utilisateur=id_utilisateur;
		this.commentaire=commentaire;
		this.date=date;
		this.heure=heure;
	}
	
	public Commentaire(){
		
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
	
	public void setId_u(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	
	public int getId_video() {
		return id_video;
	}
	
	public void setId_video(int id_video) {
		this.id_video = id_video;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
}
