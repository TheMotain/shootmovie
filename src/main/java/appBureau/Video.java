package appBureau;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Video extends JPanel {

	JButton left,right;
	Profil p;	
	JWebBrowser webBrowser;
	
	
	public Video(final Profil p) {
		this.p=p;
		
		setLayout(new BorderLayout());
		webBrowser = new JWebBrowser();
		this.add(webBrowser, BorderLayout.CENTER);
		webBrowser.setBarsVisible(false);
		webBrowser.navigate(p.getVideos().get(Profil.indexVideoCourante).getUrl());
		NativeInterface.open();

		NativeInterface.runEventPump();
		// don't forget to properly close native components
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();
			}
		}));
		
		left= new JButton(new ImageIcon("img/fleche-gauche.png"));
		left.setContentAreaFilled(false);
		right= new JButton(new ImageIcon("img/fleche-droite.png"));
		right.setContentAreaFilled(false);
		right.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(right)){
					webBrowser.navigate(p.getVideos().get(++Profil.indexVideoCourante).getUrl());
				
				}
				
			}
		});
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(new JPanel(),BorderLayout.SOUTH);
		
	}
}
