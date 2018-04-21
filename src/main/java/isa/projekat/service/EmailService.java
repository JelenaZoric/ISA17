package isa.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import isa.projekat.model.Seat;
import isa.projekat.model.User1;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;
	
	@Async
	public void sendNotificaitionAsync(User1 user) throws MailException, InterruptedException {

		//Simulacija duze aktivnosti da bi se uocila razlika
		System.out.println("usao u metodu///////////////////////////");
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		System.out.println("adresa postavljena na " + user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		System.out.println("posaljilac postavljen///////////");
		mail.setSubject("Potvrda registrovanja");
		mail.setText("Pozdrav " + user.getName() + ",\n\nmolimo potvrdite registraciju klikom na link. "
				+ "\n\n\"http://localhost:8090/myapp/users/searching/" + user.getId() + "\"");
		System.out.println("tekst maila postavljen");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	public void sendNotificaitionSync(User1 user) throws MailException, InterruptedException {

		//Simulacija duze aktivnosti da bi se uocila razlika
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		//mail.setTo("teodora.b.95@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		//mail.setFrom("teodora.b.95@gmail.com");
		mail.setSubject("Potvrda logovanja");
		mail.setText("Pozdrav " + user.getName() + ",\n\nupravo si uspela da posaljes mail.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendEmailInvitation(User1 toWho, User1 fromWho, Seat seat) throws MailException, InterruptedException {

		//Simulacija duze aktivnosti da bi se uocila razlika
		System.out.println("usao u metodu///////////////////////////");
		Thread.sleep(10000);
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toWho.getEmail());
		System.out.println("adresa postavljena na " + toWho.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		System.out.println("posaljilac postavljen///////////");
		mail.setSubject("Pozivnica za predstavu");
		mail.setText("Pozdrav " + toWho.getName() + ",\n\ndobili ste pozivnicu od " + fromWho.getName() 
				+ "za predstavu " + seat.getHall().getDate().getPlay().getName() + ",molimo potvrdite dolazak klikom na link. "
			/*	+ "\n\n\"http://localhost:8090/myapp/users/searching/" + user.getId() + "\"" */);
		System.out.println("tekst maila postavljen");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
}
