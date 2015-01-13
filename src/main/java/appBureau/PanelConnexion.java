package appBureau;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelConnexion extends JPanel {
	
	private JLabel connexion,login,mdp;
	private JTextArea log,pass;
	
	
	
	public PanelConnexion() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		connexion= new JLabel("Connexion");
		login= new JLabel("login");
		mdp= new JLabel("mot de passe");
		log= new JTextArea();
		pass= new JTextArea();
		
		add(connexion);
		add(login);
		add(log);
		add(mdp);
		add(pass);
		
		
		
		
		
	}
	
	

}
