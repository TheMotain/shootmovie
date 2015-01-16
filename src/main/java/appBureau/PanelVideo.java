package appBureau;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;

public class PanelVideo extends JPanel {

	PanelProfil pp;
	Video v;

	public PanelVideo(PanelProfil pp) {

		this.pp = pp;
		v = new Video(pp.p);
		setLayout(new BorderLayout());
		add(pp, BorderLayout.WEST);
		add(v, BorderLayout.CENTER);

		pp.upload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getPanelProfil().up = new Upload(getPanelProfil());
				getPanelProfil().up.valider.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								// if(!getPanelProfil().up.titreField.getText().equals("")
								// ||
								// !getPanelProfil().up.urlField.getText().equals("")){//&&
								// !getPanelProfil().up.descriptionField.getText().equals("")){
								getPanelProfil().videodao.insertVideo(
										getPanelProfil().up.titreField
												.getText(),
										getPanelProfil().up.descriptionField
												.getText(), new Date()
												.toString(),
										getPanelProfil().up.urlField.getText(),
										getPanelProfil().pseudo.getText());
								
								getPanelProfil().getProfil().updateVideos();
								remove(v);
								v = new Video(getPanelProfil().getProfil());
								add(v);
								v.validate();
								v.revalidate();
								v.repaint();
								getPanelProfil().up.dispose();
								System.out.println("ok");
							}

							// }
						});

			}
		});

	}

	PanelProfil getPanelProfil() {
		return pp;
	}

}
