package fr.iutinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

//TEST COMMIT
public class VideoTest extends JerseyTest {
	@Override
    protected Application configure() {
        return new App();
    }

	@Test
	public void testReadVideoWithTitleFooAsJsonString() {
		createVideo("foo");
		String json = target("/video/foo").request().get(String.class);
		assertEquals("{\"id\":5,\"titre\":\"foo\"}", json);
	}

	@Test
	public void testReadVideoWithNameFooAsObject() {
		Video video = target("/video/foo").request().get(Video.class);
		assertEquals("foo", video.getTitre());
	}
	
	@Test
	public void testcreateVideoMustReturnUserWithId() {
		Video savedVideo = createVideo("thomas");
		assertTrue(savedVideo.getId() > 0);
	}

	@Test
	public void testUpdateUserName() {
		User u = null;//createVideo("thomas");
		u.setPseudo("yann");
		Response rep = target("/user").path(""+u.getId()).request()
				.put(Entity.entity(u,MediaType.APPLICATION_JSON));;
		User updatedUser = rep.readEntity(User.class);
		assertEquals("yann", updatedUser.getPseudo());
	}
	
	@Test
	public void testGetingSameVideoTwice() {
		Video video1 = target("/video/foo").request().get(Video.class);
		Video video2 = target("/video/foo").request().get(Video.class);
		assertEquals(video1, video2);
	}
	
	@Test
	public void testReadUnavailableUser () {
		int status = target("/user/bar").request().get().getStatus();
		assertEquals(404, status);
	}
	
	@Test
	public void tesListAllVideos() {
		createVideo("toto");
		createVideo("titi");
		List<Video> videos = target("/video/").request().get(new GenericType<List<Video>>(){});
		assertTrue(videos.size() >= 2);
	}

	@Test
	public void testDeleteVideo() {
		Video u = createVideo("toto");
		int status = target("/video/"+u.getId()).request().delete().getStatus();
        assertEquals(202, status);
        
	}
	
	private Video createVideo(String titre) {
		Video v = new Video();
	    Entity<Video> videoEntity = Entity.entity(v, MediaType.APPLICATION_JSON);
		Video video = target("/video").request().post(videoEntity).readEntity(Video.class);
		return video;
	}
	
	/**
	 * Permet de vérifier si le lien ajouté est compatible avec l'ajout dans une page HTML5
	 */
	@Test
	public void textToLien() {
		Video v = new Video("", "", "", "", null);
		assertEquals("www.youtube.com/embed/yNpOz44RM20", v.verficationLien("https://www.youtube.com/watch?v=yNpOz44RM20"));
	}
	
}