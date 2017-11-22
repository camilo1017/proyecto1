package co.ceiba.service;

import co.ceiba.domain.Person;

public class NotifyPersonService {
	private EmailService emailService;
	public NotifyPersonService(EmailService emailService) {
		super();
		this.emailService = emailService;
	}
	public String notify(Person person) {
		String message ="Welcome "+person.getName();
		return emailService.sendEmail(message);
	}
}
