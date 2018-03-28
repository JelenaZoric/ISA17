package isa.projekat.controller;

import java.util.List;

import isa.projekat.model.Theater;
import isa.projekat.repository.TheaterRepository;
import isa.projekat.service.TheaterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="theaters")
public class TheaterController {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping(value="getTheaters", method=RequestMethod.GET)
	public ResponseEntity<List<Theater>> getTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		return new ResponseEntity<List<Theater>>(theaters,HttpStatus.OK);
	}
}
