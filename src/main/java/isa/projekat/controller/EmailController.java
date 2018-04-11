package isa.projekat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.projekat.model.User1;
import isa.projekat.service.EmailService;

//@RequestMapping(value = "/users")
public class EmailController {

	/*private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public String getNew(Model model) {
		model.addAttribute("user", new User1());
		return "Login";
	}

	@RequestMapping("/signup/async")
	public String signUpAsync(User1 user){

		//slanje emaila
		try {
			emailService.sendNotificaitionAsync(user);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "theaters";
	}  */
}
