package appBureau;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
		private JLabel logo;
		private PanelConnexion pc;
	
	
	public PanelPrincipal() {
		
		
		setLayout(new BorderLayout(100, 100));
		
		
		logo= new JLabel(new ImageIcon("img/logo.png"));
		add(logo,BorderLayout.NORTH);
		
		pc= new PanelConnexion();
		//add(new Connexion(),BorderLayout.CENTER);
		
		add(new JLabel(),BorderLayout.SOUTH);
		add(new JLabel(),BorderLayout.EAST);
		add(new JLabel(),BorderLayout.WEST);
		
	}
	
	
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;


	g2d.drawImage(new ImageIcon("img/background.jpg").getImage(), 0, 0, getWidth()	, getHeight(),null);
	
	}

}
