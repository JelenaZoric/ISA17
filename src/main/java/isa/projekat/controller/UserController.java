package isa.projekat.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import isa.projekat.model.Seat;
import isa.projekat.model.Theater;
import isa.projekat.model.User1;
import isa.projekat.repository.UserRepository;
import isa.projekat.service.EmailService;
import isa.projekat.service.SeatService;
import isa.projekat.service.TheaterService;
import isa.projekat.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private SeatService seatService;
	
//	@Autowired
//	private UserRepository userRepository;

/*	@RequestMapping(value = "/search/{name}/{lastname}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User1 getUserByName(@PathVariable String name, @PathVariable String lastname) {
		return this.userService.findOne(name, lastname);
	}     */
	@RequestMapping(value = "/searching/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User1 getUserByName(@PathVariable Long id) {
		this.userService.findOne(id).setEnabled("true");
		//i sacuvam ga opet valjda
		System.out.println(this.userService.findOne(id).getName());
		System.out.println(this.userService.findOne(id).getEnabled());
		return this.userService.findOne(id);
	}
	
	@RequestMapping(value = "/search/{criteria}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<User1> getUserByCriteria(@PathVariable String criteria) {
		return this.userService.findUsers(criteria, new PageRequest(0, 10));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getUsers")
	public ResponseEntity<List<User1>> getHome() {
		List<User1> users = userService.findAll();
		//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		return new ResponseEntity<List<User1>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<User1> addUser(@RequestBody User1 user){
		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("email je " + user.getEmail() + "....................");
		try {
			emailService.sendNotificaitionAsync(user);
			//emailService.sendNotificaitionSync(user);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		user.setEnabled("false");
		User1 newUser = userService.save(user);
		System.out.println(newUser.getEnabled() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//response.sendRedirect("theaters.html");
		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(URI.create("http://localhost:8090/myapp/theaters.html"));
	//	return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
		//return "redirect:theaters";
	}
	
	//@RequestMapping(value = "/log")
	@RequestMapping(method=RequestMethod.POST, value = "/log", consumes="application/json")
	public ResponseEntity<User1> logUser(@RequestBody User1 user){
		User1 logedUser = userService.getUser(user.getEmail(), user.getPassword());
		
		if(logedUser == null){
			System.out.println("Pogresna kombinacija emaila i sifre!");
			return new ResponseEntity<>(logedUser, HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Korisnik " + logedUser.getName() + " se uspesno ulogovao!");
		return new ResponseEntity<>(logedUser, HttpStatus.OK);
	}
	
	@RequestMapping(value="getUser", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User1> getUser(@RequestParam("id") Long id){
		User1 user = userService.findOne(id);
		return new ResponseEntity<User1>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/reserve/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<User1> reserve(@PathVariable("id") Long id, @RequestBody Seat seat){
		User1 edited = userService.findOne(id);
		//theaterService.save(theater);
		System.out.println(seat.getId());
		seat = seatService.findOne(seat.getId());
		seat.setReserved("rezervisano");
		edited.getSeats().add(seat);
		userService.save(edited);
		return new ResponseEntity<User1>(edited, HttpStatus.OK);
	}
}
