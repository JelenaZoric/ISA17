package isa.projekat.controller;

import isa.projekat.model.Seat;
import isa.projekat.repository.SeatRepository;
import isa.projekat.service.SeatService;

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
	
	//rezervisanje karte na popustu
	@RequestMapping(value="reserve/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Seat> reserve(@PathVariable("id") Long id) {
		Seat seat = seatService.findOne(id);
		seat.setReserved("rezervisano");
		seatService.save(seat);
		return new ResponseEntity<Seat>(seat, HttpStatus.OK);
	}
}
