package appBureau;

import javax.swing.JPanel;

public class Video extends JPanel {
/*
	JButton left,right;
	Profil p;	
	JWebBrowser webBrowser;
	int index = 0;
	
	public Video(final Profil p) {
		this.p=p;
		
		setLayout(new BorderLayout());
		webBrowser = new JWebBrowser();
		left= new JButton(new ImageIcon("img/fleche-gauche.png"));
		right= new JButton(new ImageIcon("img/fleche-droite.png"));
		
		webBrowser.setBarsVisible(false);
		if(p.getListVideos().size()>=1){
			webBrowser.navigate(p.getListVideos().get(0).getUrl());
			this.add(webBrowser, BorderLayout.CENTER);
		}
		else{
			this.add(new NoFoundVideo(),BorderLayout.CENTER);
			left.setEnabled(false);
			right.setEnabled(false);
		}
		NativeInterface.open();

		//NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();
			}
		}));
		
		
		left.setContentAreaFilled(false);
		left.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index >=1){
					index--;
				}else{
					index = p.getListVideos().size()-1;
				}
				webBrowser.navigate(p.getListVideos().get(index).getUrl());
				System.out.println(index);
			}
		});
	
		
		
		
		
		right.setContentAreaFilled(false);
		right.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index < p.getListVideos().size()-1){
					index++;
			
				}else{
					index = 0;
				}
				webBrowser.navigate(p.getListVideos().get(index).getUrl());
				System.out.println(index);
			}
		});
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(new JPanel(),BorderLayout.SOUTH);
		
	setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
}*/
}
