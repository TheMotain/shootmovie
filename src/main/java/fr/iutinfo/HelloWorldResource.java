package fr.iutinfo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	public static final String CLICHED_MESSAGE = "Hello World!";

	@GET
	public String getHello() {
		return CLICHED_MESSAGE;
	}
}