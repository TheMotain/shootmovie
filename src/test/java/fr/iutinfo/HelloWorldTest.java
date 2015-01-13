package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class HelloWorldTest extends JerseyTest{
	@Override
    protected Application configure() {
        return new App();
    }
	@Test
	public void testLogin() {
		Signin user1 = target("/helloworld").request().get(Signin.class);
		assertEquals(user1, "Hello World!");
	}
}
