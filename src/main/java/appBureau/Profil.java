package appBureau;

import javax.swing.ImageIcon;

public class Profil {

	
	private String pseudo,age,dateCreation,img;
	private ImageIcon photo;
	
	
	public Profil(String pseudo,String age,String dateCreation,String img) {
		
		
		this.pseudo=pseudo;
		this.age=age;
		this.dateCreation=dateCreation;
		this.setImg(img);
		
		photo= new ImageIcon(img);		
		

		
		
		
		
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
	
	
	
	
	
	
}
