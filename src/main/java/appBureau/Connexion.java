package appBureau;

import javax.swing.*;
import fr.iutinfo.App;
import fr.iutinfo.User;
import fr.iutinfo.UserDao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Connexion {

	JFrame frame = new JFrame();

	JPanel textPanel, panel, completionPanel;
	JLabel titleLabel, usernameLabel, passwordLabel, userLabel, passLabel;
	JTextField usernameField;
	JPasswordField loginField;
	JButton loginButton;
	private static UserDao userdao = App.dbi.open(UserDao.class);

	public Connexion() {
		AutoRemplissageBDD.remplissageUsers();
		AutoRemplissageBDD.remplissageVideos();
		Container c = frame.getContentPane();
		c.setBackground(new Color(68, 68, 68));
		c.setLayout(new BorderLayout());
		JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
		c.add(logo, BorderLayout.NORTH);
		JPanel jp = new JPanel();
		jp.setBackground(new Color(68, 68, 68));
		jp.setLayout(new BorderLayout(100, 20));
		JPanel est = new JPanel();
		est.setOpaque(false);
		JPanel ouest = new JPanel();
		ouest.setOpaque(false);
		jp.add(est, BorderLayout.EAST);
		jp.add(ouest, BorderLayout.WEST);
		c.add(jp, BorderLayout.CENTER);
		jp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		titleLabel = new JLabel("Connexion");
		titleLabel.setFont(new Font("f", Font.BOLD, 20));
		titleLabel.setForeground(Color.white);
		titleLabel.setPreferredSize(new Dimension(50, 30));
		titleLabel.setHorizontalAlignment(0);
		jp.add(titleLabel, BorderLayout.PAGE_START);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		jp.add(panel, BorderLayout.CENTER);

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
		JPanel connexion = new JPanel();
		loginButton = new JButton("connexion");
		loginButton.setPreferredSize(new Dimension(150, 27));
		connexion.add(loginButton);
		connexion.setOpaque(false);
		jp.add(connexion, BorderLayout.PAGE_END);
		loginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				User res = userdao.selectUser(usernameField.getText(), loginField.getText());
				if (res != null) {
					String pseudo = res.getPseudo();
					String dateInscription = res.getDateInscription();
					frame.dispose();
					JFrame test = new JFrame();
					test.setSize(800, 500);
					Profil p= new Profil(pseudo, dateInscription, "18");
				p.updateVideos();
					test.add(new PanelVideo(new PanelProfil(p)));
					test.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(frame, "login ou mot de passe incorrect", "Attention", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		frame.setSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Connexion();
	}

}
