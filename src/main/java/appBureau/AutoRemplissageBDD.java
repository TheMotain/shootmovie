package appBureau;

import java.util.Iterator;

import fr.iutinfo.App;
import fr.iutinfo.UserDao;
import fr.iutinfo.VideoDao;

public class AutoRemplissageBDD {

	
	private static UserDao userdao = App.dbi.open(UserDao.class);
	private static VideoDao videodao = App.dbi.open(VideoDao.class);
	
	public static void remplissageUsers(){
		userdao.dropTable();
		userdao.createTable();
	
		userdao.insertUser("moi", "moi", "10-10-14");
		userdao.insertUser("toi", "toi", "30-11-15");
		userdao.insertUser("toto", "toto", "20-12-15");

	}
	
	public static void remplissageVideos(){
		videodao.dropTable();
		videodao.createTable();
		videodao.insertVideo("J-Art & Madan feat. Lyon Hart - The Sound Of Silence ", "Electro Posé (WDEF) - French music diffuser... ", "14-01-2015", "www.youtube.com/embed/qRnloYNFu-c", "toto");
		videodao.insertVideo("Mattafix - Big City Life ", "Mattafix - Big City Life ", "14-01-2015", "www.youtube.com/embed/4mtfnfQoAco", "toto");
		videodao.insertVideo("One-T & Cool-T - The Magic Key", "Music Video", "14-01-2008", "www.youtube.com/embed/2nSvaqKcwSc", "toto");
		
		Iterator<fr.iutinfo.Video> it = videodao.getAllVideo();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
}
