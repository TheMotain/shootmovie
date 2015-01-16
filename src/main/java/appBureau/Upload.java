package appBureau;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Upload extends JFrame{
	
	
	JPanel p;
	JLabel titre,description,url;
	JTextField titreField,descriptionField,urlField;
	JButton valider;
	
	PanelProfil pf;
	Video v;
	public Upload(PanelProfil pf) {
		super("Ajouter une nouvelle vidéo");
		this.pf = pf;
		setSize(new Dimension(300,180));
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		
		this.titre=new JLabel("Titre:");
		description=new JLabel("Description:");
		url=new JLabel("Url:");
		valider= new JButton("valider");
		valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getPf().videodao.insertVideo(getPf().up.titreField.getText(),getPf().up.descriptionField.getText(), new Date().toString(),getPf().up.urlField.getText(),getPf(). pseudo.getText());
				getPf().getProfil().updateVideos();
				v=new Video(getPf().getProfil());
				getPf().up.dispose();
				System.out.println("ok");
				
			}
		});
		
		titreField= new JTextField();
		descriptionField= new JTextField();
		urlField= new JTextField();
		
		p= new JPanel(new GridLayout(5,2,10,5));
		
		p.add(this.titre);
		p.add(titreField);
		p.add(description);
		p.add(descriptionField);
		p.add(url);
		p.add(urlField);
		
		
		
		getContentPane().add(p);
		getContentPane().add(valider);
		
		
		
		
		
		setVisible(true);
		
		
		
		
		
	}
	
	PanelProfil getPf(){
		return pf;
	}

	
}
