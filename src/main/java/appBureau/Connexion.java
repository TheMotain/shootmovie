package appBureau;
	import javax.swing.*;
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.Color;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
public class Connexion extends JPanel{

	    JPanel textPanel, panelForTextFields, completionPanel;
	    JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
	    JTextField usernameField, loginField;
	    JButton loginButton ;

	    public Connexion(){

	        
	
	     setLayout(new BorderLayout(100, 100));
	    
	        titleLabel = new JLabel("Connexion");
	        titleLabel.setPreferredSize(new Dimension(290, 30));
	        titleLabel.setHorizontalAlignment(0);
	        add(titleLabel, BorderLayout.PAGE_START);

	  
	        textPanel = new JPanel();
	        textPanel.setPreferredSize(new Dimension(70, 80));
	        add(textPanel, BorderLayout.LINE_START);

	        
	        usernameLabel = new JLabel("Login");
	        usernameLabel.setPreferredSize(new Dimension(70, 30));
	        usernameLabel.setHorizontalAlignment(4);
	        textPanel.add(usernameLabel);

	       
	        passwordLabel = new JLabel("Mot de passe");
	        passwordLabel.setPreferredSize(new Dimension(70, 30));
	        passwordLabel.setHorizontalAlignment(4);
	        textPanel.add(passwordLabel);

	   
	        panelForTextFields = new JPanel();
	        panelForTextFields.setPreferredSize(new Dimension(100, 70));
	        add(panelForTextFields, BorderLayout.CENTER);

	   
	        usernameField = new JTextField(8);
	        usernameField.setPreferredSize(new Dimension(100, 30));
	        panelForTextFields.add(usernameField);

	      
	        loginField = new JTextField(8);
	        loginField.setPreferredSize(new Dimension(100, 30));
	        panelForTextFields.add(loginField);

	        
	        completionPanel = new JPanel();
	        completionPanel.setPreferredSize(new Dimension(70, 80));
	        add(completionPanel, BorderLayout.LINE_END);

	
	        userLabel = new JLabel("Wrong");
	        userLabel.setForeground(Color.red);
	        userLabel.setPreferredSize(new Dimension(70, 30));
	        completionPanel.add(userLabel);


	        passLabel = new JLabel("Wrong");
	        passLabel.setForeground(Color.red);
	        passLabel.setPreferredSize(new Dimension(70, 30));
	        completionPanel.add(passLabel);

	
	        loginButton = new JButton("Login");
	        add(loginButton, BorderLayout.PAGE_END);

	    setOpaque(true);
	       
	    }

	
}
