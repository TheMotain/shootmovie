package fr.iutinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/video")
@Produces(MediaType.APPLICATION_JSON)
public class VideoResource {
	private static Map<Integer, Video> videos = new HashMap<>();
	
	@POST
	public Video createVideo(Video v) {
		int id = videos.size();
		v.setId(id+1);
		videos.put(v.getId(), v);
		return v;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteVideo(@PathParam("id") Integer id) {
		if (videos.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Video find(String name) {
		Video out = null;
		for (Video video : videos.values()) {
			if (video.getTitre().equals(name)) {
				return video;
			}
		}
		return out;
	}
	protected Video find(int id) {
		return videos.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateVideo(@PathParam("id") int id, 
			Video video) {
		Video oldVideo = find(id);
		System.out.println("Should update video with id: "+id
				+" ("+oldVideo+") to " +video);
		if (video == null) {
			throw new WebApplicationException(404);
		}
		oldVideo.setTitre(video.getTitre());
		return Response.status(200).entity(oldVideo).build();
	}
	
	@GET
	@Path("/{name}")
	public Video getVideo(@PathParam("name") String name ) {
		Video out = find(name);
		if (out == null) {
			throw new WebApplicationException(404);
		} 
		return out;
	}
	
	@GET
	public List<Video> getVideos(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Video>(videos.values());
	}
}
