package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	//Randomly created test email's
	private static final String TEST_EMAILS[] = {"djs@gmail.com", "afdj@gds.org","ab@c.com"};
	
	//Concrete email class for testing
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception{
		
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception{
		
	}
	/*
	Testing the Email  addBcc(String) method
	84.8% Coverage
	*/
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS);
		//There are 3 email's in TEST_EMAILS, we have to confirm that all 3 are in BccAdresses
		assertEquals(3,email.getBccAddresses().size());
	}
	/*
	Testing the Email  addCc(String) method
	100% Coverage
	*/
	@Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAILS[0]);
		//Checking if one email has been added
		assertEquals(1,email.getCcAddresses().size());
	}
	/*
	Testing the addHeader(String,String) method
	78.3% Coverage
	*/
	@Test
	public void testAddHeader() throws Exception{
		email.addHeader("MUST_READ", "Hi");
	}
	/*
	Testing the addHeader(String,String) method to ensure that the null aspect is covered
	78.3% Coverage
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeaderNull() throws Exception{
		email.addHeader("MUST READ", "");
	}
	/*
	Testing the addReplyTo(String email, String name) method
	100% Coverage
	*/
	@Test
	public void testAddReplyTo() throws Exception{
		email.addReplyTo(TEST_EMAILS[0]);
		//assertEquals(TEST_EMAILS[0],email.getReplyToAddresses());
	}
	/*
	Testing the buildMimeMessage() method
	65.8% Coverage
	*/
	@Test
	public void testMimeMessage() throws Exception {
	  email.setHostName("localHost");
	  email.setSmtpPort(1234);
	  email.setFrom("abc@gmail.com");
	  email.addTo("c@d.com");
	  email.setSubject("test mail");
	  email.addCc("this@gmail.com");
	  email.addBcc("toqp@gmail.com");
	  email.addHeader("Test", "adfa");
	  email.addReplyTo("gg@gmail.com");
	  
	  email.setCharset("ISO-8859-1");
	  email.setContent("test content", "text/plain");
	  email.buildMimeMessage();
	}
	/*
	Testing the buildMimeMessage method at null value
	*/
	@Test (expected=Exception.class)
	public void testBuildMimeMessageNull() throws Exception{
		email.buildMimeMessage();
		
	}
	
}
