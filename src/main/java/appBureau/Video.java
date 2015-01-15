package appBureau;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Video extends JPanel {

	JButton left,right;
	
	
	public Video(String url) {
		setLayout(new BorderLayout());
		JWebBrowser webBrowser = new JWebBrowser();
		this.add(webBrowser, BorderLayout.CENTER);
		webBrowser.setBarsVisible(false);
		webBrowser.navigate(url);
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
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(new JPanel(),BorderLayout.SOUTH);
		
	}



}
