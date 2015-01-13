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
	public void testGetingSameUserTwice() {
		Signin user1 = target("/Signin?login=admin&mdp=admin").request().get(Signin.class);
		assertEquals(user1, "yes");
	}
}
