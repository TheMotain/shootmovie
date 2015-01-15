package appBureau;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelVideo extends JPanel{
	
	PanelProfil pp;
	
	public PanelVideo(PanelProfil pp) {
		
	this.pp=pp;
	
	setLayout(new BorderLayout());
	add(pp,BorderLayout.WEST);
	add(new JPanel(),BorderLayout.CENTER);
		
	}
	
	

}
