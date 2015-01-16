package appBureau;

//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JPanel;
//
//import chrriis.dj.nativeswing.swtimpl.NativeInterface;
//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Video extends JPanel {
//
//	JButton left,right;
//	Profil p;	
//	JWebBrowser webBrowser;
//	int index = 0;
//	
//	public Video(final Profil p) {
//		this.p=p;
//		
//		setLayout(new BorderLayout());
//		webBrowser = new JWebBrowser();
//		this.add(webBrowser, BorderLayout.CENTER);
//		webBrowser.setBarsVisible(false);
//		webBrowser.navigate(p.getListVideos().get(0).getUrl());
//		NativeInterface.open();
//
//		NativeInterface.runEventPump();
//		// don't forget to properly close native components
//		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//			@Override
//			public void run() {
//				NativeInterface.close();
//			}
//		}));
//		
//		left= new JButton(new ImageIcon("img/fleche-gauche.png"));
//		left.setContentAreaFilled(false);
//		left.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(index >=1){
//					index--;
//				}else{
//					index = p.getListVideos().size()-1;
//				}
//				webBrowser.navigate(p.getListVideos().get(index).getUrl());
//				System.out.println(index);
//			}
//		});
//	
//		
//		
//		
//		right= new JButton(new ImageIcon("img/fleche-droite.png"));
//		right.setContentAreaFilled(false);
//		right.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(index < p.getListVideos().size()-1){
//					index++;
//			
//				}else{
//					index = 0;
//				}
//				webBrowser.navigate(p.getListVideos().get(index).getUrl());
//				System.out.println(index);
//			}
//		});
//		this.add(left,BorderLayout.WEST);
//		this.add(right,BorderLayout.EAST);
//		this.add(new JPanel(),BorderLayout.SOUTH);
//		
//	}
}
