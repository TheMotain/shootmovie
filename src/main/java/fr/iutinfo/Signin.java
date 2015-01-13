package fr.iutinfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Signin")
@Produces(MediaType.APPLICATION_JSON)
public class Signin {
	
	@GET
	public String Connect(@QueryParam("login") String login, @QueryParam("mdp") String mdp){
		if(login.equals("admin") && mdp.equals("admin"))
			return "yes";
		else
			return "no";
	}
}
