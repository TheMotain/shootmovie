package fr.iutinfo;

public class Video {
	
	private int id;
	private String titre;
	private String description;
	private String dateUpload;
	private String url;
	private int realisateur;
	private double note;
	private int compteur;
	
	public Video(String titre, String description, String dateUpload, String url, int realisateur){
		this.titre = titre;
		this.description = description;
		this.dateUpload = dateUpload;
		this.url = url;
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
	public String getDateUpload() {
		return dateUpload;
	}
	public void setDateUpload(String dateUpload) {
		this.dateUpload = dateUpload;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public int getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(int realisateur) {
		this.realisateur = realisateur;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	
	public void setCompteur(int compteur) {
		this.compteur=compteur;
	}
	
	public void setCompteur() {
		compteur++;
	}
	
	public int getCompteur() {
		return compteur;
	}

	
	@Override
	public String toString() {
		return "Video [id=" + id + ", titre=" + titre + ", description=" + description + ", dateUpload=" + dateUpload + ", url=" + url + ", realisateur="
				+ realisateur + ", note=" + note + ", compteur=" + compteur + "]";
	}
}
