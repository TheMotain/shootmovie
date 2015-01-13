package appBureau;

import javax.swing.JFrame;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		
		JFrame jf= new JFrame();
		jf.setSize(400, 300);
		jf.setTitle("ShootMovie");
		jf.setLocation(500, 250);
		jf.setResizable(false);
		jf.add(new PanelPrincipal());
		jf.setVisible(true);
		
		
		
	}

}
