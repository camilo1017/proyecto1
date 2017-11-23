package co.ceiba.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;
import junit.framework.Assert;

public class NotifyPersonServiceTest {
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setUp() {
		emailService=Mockito.mock(EmailService.class);
		notifyPersonService=new NotifyPersonService(emailService);		
	}
	
	@Test
	public void notifyTest() {
		//Arrange
		Person person=new PersonTestDataBuilder().build();
		Mockito.when(emailService.sendEmail(Mockito.anyString())).thenReturn("Hola mundo");	
		//Act
		String message=notifyPersonService.notify(person);
		//Assert
		assertNotNull(message);
		System.out.println(message);
	}
}
