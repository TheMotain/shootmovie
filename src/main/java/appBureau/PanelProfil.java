package appBureau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.iutinfo.App;
import fr.iutinfo.VideoDao;

@SuppressWarnings("serial")
public class PanelProfil extends JPanel {

	
	Profil p;
	JLabel photo,pseudo,age,datecreation,nbreAbos;
	JPanel info;
	JButton upload;
	Upload up;
	static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	
	PanelProfil(Profil p){
		this.p=p;
		
		photo= new JLabel(this.p.getPhoto());
		pseudo= new JLabel(this.p.getPseudo());
		pseudo.setForeground(Color.red);
		pseudo.setFont(new Font("x", Font.BOLD, 30));
		age= new JLabel(this.p.getAge()+" ans");
		datecreation= new JLabel("Membre depuis le "+this.p.getDateCreation());
		nbreAbos= new JLabel(p.getNbreAbonnes() + " abonnés");
		setLayout(new BorderLayout(20,50));
		add(photo,BorderLayout.PAGE_START);
		
		info= new JPanel();
		info.setOpaque(false);
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		info.add(pseudo);
		info.add(age);
		info.add(datecreation);
		info.add(nbreAbos);
		
		add(info,BorderLayout.CENTER);
		
		upload= new JButton(new ImageIcon("img/upload.jpg"));
		upload.setContentAreaFilled(false);

		//upload.setPreferredSize(new Dimension(200,100));
		add(upload,BorderLayout.SOUTH);
		up= new Upload(this);

				
				
	}
			
	Profil getProfil(){
		return p;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;


	g2d.drawImage(new ImageIcon("img/background.jpg").getImage(), 0, 0, getWidth()	, getHeight(),null);
	
	}

	
}
