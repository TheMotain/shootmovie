package fr.iutinfo;

public class Video {
	
	private int id;
	private String titre;
	private String description;
	private String date_upload;
	private String lien;
	private User realisateur;
	private double note;
	private int compteur;
	
	public Video(String titre, String description, String date_upload, String lien, User realisateur){
		this.titre = titre;
		this.description = description;
		this.date_upload = date_upload;
		this.lien = lien;
		this.realisateur = realisateur;
		note = 0.0;
		compteur=0;
	}
	
	/**
	 * Vérifie si le lien ajouté est compatible avec l'ajout dans une page HTML5
	 * Retourne le lien sous la forme compatibe intégration HTML5
	 */
	public String verficationLien(String lien){
		if(lien.contains("www.youtube.com/embed/") == false){
			String res[] = lien.split("=");
			res[1] = "www.youtube.com/embed/" + res[1];
			return res[1];
		}
		
		return lien;
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
	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
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
	
	public void setCompteur1(int compteur) {
		this.compteur=compteur;
	}
	
	public void setCompteur() {
		compteur++;
	}
	
	public int getCompteur() {
		return compteur;
	}

}
