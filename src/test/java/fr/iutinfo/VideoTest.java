package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

//TEST COMMIT
public class VideoTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new App();
	}
	
	/**
	 * Permet de vérifier si le lien ajouté est compatible avec l'ajout dans une
	 * page HTML5
	 */
	@Test
	public void textToLien() {
		Video v = new Video("", "", "", "", null);
		assertEquals("www.youtube.com/embed/yNpOz44RM20", v.verficationLien("https://www.youtube.com/watch?v=yNpOz44RM20"));
	}

}