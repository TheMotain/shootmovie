package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class SigninTest extends JerseyTest{
	@Override
    protected Application configure() {
        return new App();
    }
	@Test
	public void testPing() {
		String user1 = target("/signin/ping").request().get(String.class);
		System.out.println("--------------- PING ----------------");
		assertEquals("Yes !", user1);
	}
	@Test
	public void testLogin() {
		String user1 = target("/signin?login=admin&mdp=admin").request().get(String.class);
		System.out.println("--------------- testLogin ---------------- "+user1);
		assertEquals("yes", user1);
	}
}
