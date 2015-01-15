package fr.iutinfo;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

public class EssaiClientREST {

	public static void main(String[] args) {
		Client client  = ClientBuilder.newClient();
		List<User> user = client.target("http://localhost:8080/v1/user").request().get(new GenericType<List<User>>(){});
		System.out.println(user);
	}
	
}
