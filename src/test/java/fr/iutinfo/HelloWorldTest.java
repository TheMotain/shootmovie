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
	public void testHelloWorld() {
		String user1 = target("/helloworld").request().get(String.class);
		System.out.print("************************************************** testHelloWorld: "+user1);
		assertEquals(HelloWorldResource.CLICHED_MESSAGE, user1);
	}
}
