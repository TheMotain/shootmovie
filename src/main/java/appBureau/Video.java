package appBureau;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Video extends JPanel {

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
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("YouTube Viewer");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(
				new Video("http://www.youtube.com/embed/yNpOz44RM20"),
				BorderLayout.CENTER);
		frame.setSize(720, 480);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}

}
