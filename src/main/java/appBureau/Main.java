package appBureau;

import javax.swing.JFrame;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		
		JFrame jf= new JFrame();
		jf.setSize(600, 800);
		jf.setTitle("ShootMovie");
		jf.setResizable(false);
		jf.add(new PanelPrincipal());
		jf.setVisible(true);
		
		
		
	}

}
