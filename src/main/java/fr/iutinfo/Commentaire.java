package fr.iutinfo;

public class Commentaire {
	
	private int id_c;
	private int id_v;
	private int id_u;
	private String commentaire;
	
	
	public Commentaire(int id_c, int id_v, int id_u, String commentaire) {
		this.id_c=id_c;
		this.id_v=id_v;
		this.id_u=id_u;
		this.commentaire=commentaire;
	}
	
public Commentaire(){
		
	}
	
	public int getId() {
		return id_c;
	}
	public void setId(int id_c) {
		this.id_c = id_c;
	}
	public int getId_u() {
		return id_u;
	}
	public void setId_u(int id_u) {
		this.id_u = id_u;
	}
	public int getId_v() {
		return id_v;
	}
	public void setId_v(int id_v) {
		this.id_v = id_v;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	

}
