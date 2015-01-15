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

@Path("/commentaire")
@Produces(MediaType.APPLICATION_JSON)
public class CommentaireRessource {
	private static Map<Integer, Commentaire> commentaires = new HashMap<>();
	
	@POST
	public Commentaire createCommentaire(Commentaire c) {
		int id_c = commentaires.size();
		c.setId(id_c+1);
		commentaires.put(c.getId(), c);
		return c;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteCommentaire(@PathParam("id_c") Integer id_c) {
		if (commentaires.containsKey(id_c)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Commentaire find_v(int id_v) {
		Commentaire out = null;
		for (Commentaire commentaire : commentaires.values()) {
			if (commentaire.getId_v()==(id_v)) {
				return commentaire;
			}
		}
		return out;
	}
	protected Commentaire find_u(int id_u) {
		Commentaire out = null;
		for (Commentaire commentaire : commentaires.values()) {
			if (commentaire.getId_u()==(id_u)) {
				return commentaire;
			}
		}
		return out;
	}
	protected Commentaire find(int id_c) {
		return commentaires.get(id_c);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateCommentaire(@PathParam("id_c") int id_c, 
			Commentaire commentaire) {
		Commentaire oldCommentaire = find(id_c);
		System.out.println("Should update comment with id: "+id_c
				+" ("+oldCommentaire+") to " +commentaire);
		if (commentaire == null) {
			throw new WebApplicationException(404);
		}
		oldCommentaire.setCommentaire(commentaire.getCommentaire());
		return Response.status(200).entity(oldCommentaire).build();
	}
	
	@GET
	@Path("/{name}")
	public Commentaire getCommentaireFromIdUser(@PathParam("name") int id_u ) {
		Commentaire out = find_u(id_u);
		if (out == null) {
			throw new WebApplicationException(404);
		} 
		return out;
	}
	
	@GET
	public List<Commentaire> getUsers(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Commentaire>(commentaires.values());
	}
}

