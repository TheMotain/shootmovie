package fr.iutinfo;

public class Video {
	
	private int id;
	private String titre;
	private String description;
	private String date_upload;
	private User realisateur;
	private double note;
	
	public Video(String titre, String description, String date_upload, User realisateur){
		this.titre = titre;
		this.description = description;
		this.date_upload = date_upload;
		this.realisateur = realisateur;
		note = 0.0;
	}
	
	public Video(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_upload() {
		return date_upload;
	}
	public void setDate_upload(String date_upload) {
		this.date_upload = date_upload;
	}
	public User getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(User realisateur) {
		this.realisateur = realisateur;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}

}
