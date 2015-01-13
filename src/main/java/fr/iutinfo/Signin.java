package fr.iutinfo;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/signin")
@Produces(MediaType.APPLICATION_JSON)
public class Signin {
	
	@GET
	@Path("/ping")
	public String ping() {
		System.out.print("************************ PING ****************");
		return "Yes !";
	}
	
	@GET
	public String connect(@FormParam("login") String login, 
				@FormParam("mdp") String mdp){
		System.out.print("************************ connect with "+login+"  and "+mdp);
		if(login.equals("admin") && mdp.equals("admin"))
			return "yes";
		else
			return "no";
	}
}
