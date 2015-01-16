package appBureau;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NoFoundVideo extends JPanel {
	
	
	
	
	
	public NoFoundVideo() {

		
		
	}
	
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;


	g2d.drawImage(new ImageIcon("img/noFoundVideo.png").getImage(), 0, 0, getWidth()	, getHeight(),null);
	
	}
	
	
	

}
