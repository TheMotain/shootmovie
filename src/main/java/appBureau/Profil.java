package appBureau;

import javax.swing.ImageIcon;

import fr.iutinfo.App;
import fr.iutinfo.UserDao;

public class Profil  {

	private String pseudo,age,dateCreation,img;
	private ImageIcon photo;
	private int nbreAbonnes;
	
	public Profil(String pseudo, String dateCreation,String age) {
		this.pseudo=pseudo;
		this.dateCreation=dateCreation;
		this.age=age;
		this.setImg("img/photoProfil.jpg");
		photo= new ImageIcon(img);	
		this.setAge("30");
		this.setDateCreation("25-12-2004");
		setNbreAbonnes(0);
		
		

		
		
		
		
	}
	
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	public ImageIcon getPhoto() {
		return photo;
	}
	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getNbreAbonnes() {
		return nbreAbonnes;
	}

	public void setNbreAbonnes(int nbreAbonnes) {
		this.nbreAbonnes = nbreAbonnes;
	}
	
	

	
	
	
	
}
