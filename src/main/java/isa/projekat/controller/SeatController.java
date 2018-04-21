package isa.projekat.controller;

import isa.projekat.model.Seat;
import isa.projekat.model.User1;
import isa.projekat.model.UserDate;
import isa.projekat.repository.SeatRepository;
import isa.projekat.repository.UserRepository;
import isa.projekat.service.SeatService;
import isa.projekat.service.UserDateService;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/seats")
public class SeatController {

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDateService userDateService;
	
	//rezervisanje karte na popustu
	@RequestMapping(value="reserve/{user_id}/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Seat> reserve(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id) {
		//rezervisano sediste se dodaje u korisnikovu listu rezervacija i poseta
		Seat seat = seatService.findOne(id);
		seat.setReserved("rezervisano");
		seatService.save(seat);
		User1 user = userService.findOne(user_id);
		user.getSeats().add(seat);
		user.getTheaters().add(seat.getHall().getDate().getPlay().getTheater());
		userService.save(user);
		UserDate userDate = new UserDate(user, seat.getHall().getDate());
		userDateService.save(userDate);
		return new ResponseEntity<Seat>(seat, HttpStatus.OK);
	}
}
