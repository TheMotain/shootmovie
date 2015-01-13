package fr.iutinfo;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/video")
@Produces(MediaType.APPLICATION_JSON)
public class VideoResource {
	private static Map<Integer, Video> videos = new HashMap<>();
	
	@POST
	public User createVideo(Video v) {
		
	}
}
