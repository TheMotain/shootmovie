package appBureau;
	import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class Connexion extends JPanel{

	    JPanel textPanel, panel, completionPanel;
	    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
	    JTextField usernameField;JPasswordField loginField;
	    JButton loginButton;

	    public Connexion(){

	        
	
	     setLayout(new BorderLayout(100,20));
	     
	     setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

	        titleLabel = new JLabel("Connexion");
	        titleLabel.setFont(new Font("f", Font.BOLD, 20));
	        titleLabel.setForeground(Color.white);
	        titleLabel.setPreferredSize(new Dimension(100, 30));
	        titleLabel.setHorizontalAlignment(0);
	        add(titleLabel, BorderLayout.PAGE_START);

	        panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        add(panel, BorderLayout.CENTER);

	        
	        usernameLabel = new JLabel("Login");
	        usernameLabel.setHorizontalAlignment(4);
	        panel.add(usernameLabel);

	        usernameField = new JTextField(8);
	        panel.add(usernameField);
	        
	        passwordLabel = new JLabel("Mot de passe");
	        passwordLabel.setHorizontalAlignment(4);
	        panel.add(passwordLabel);

	        loginField = new JPasswordField(8);
	        panel.add(loginField);
	        

	        loginButton = new JButton("connexion");
	        add(loginButton, BorderLayout.PAGE_END);

	        setOpaque(false);
	       
	    }

	
}
