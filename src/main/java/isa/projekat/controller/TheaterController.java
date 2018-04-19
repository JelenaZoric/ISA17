package isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Hall;
import isa.projekat.model.Play;
import isa.projekat.model.Seat;
import isa.projekat.model.Theater;
import isa.projekat.model.dto.Converters;
import isa.projekat.model.dto.TheaterDTO;
import isa.projekat.repository.TheaterRepository;
import isa.projekat.service.SeatService;
import isa.projekat.service.TheaterService;

@RestController
@RequestMapping(value="theaters")
public class TheaterController {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private SeatService seatService;
	
	@RequestMapping(value="getTheaters", method=RequestMethod.GET)
	public ResponseEntity<List<Theater>> getTheaters() {
		List<Theater> theaters = theaterRepository.findAll();
		return new ResponseEntity<List<Theater>>(theaters,HttpStatus.OK);
	}
	
	@RequestMapping(value="getTheater", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<TheaterDTO> getTheater(@RequestParam("id") Long id) {
		Theater theater = theaterService.findOne(id);
		TheaterDTO result = Converters.convertTheaterToTheaterDTO(theater);
		return new ResponseEntity<TheaterDTO>(result, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="getTheater1", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Theater> getTheater1(@RequestParam("id") Long id) {
		Theater theater = theaterService.findOne(id);
		System.out.println(theater.getProgram());
		return new ResponseEntity<Theater>(theater, HttpStatus.OK);
	}*/
	
	//izmena
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Theater> edit(@PathVariable("id") Long id, @RequestBody Theater theater) {
		Theater edited = theaterService.findOne(id);
		edited.setName(theater.getName());
		edited.setAddress(theater.getAddress());
		edited.setCity(theater.getCity());
		edited.setDescription(theater.getDescription());
		theaterService.save(edited);
		return new ResponseEntity<Theater>(edited, HttpStatus.OK);
	}
	
	//ucitavanje karata na popustu
	@RequestMapping(method=RequestMethod.GET, value="quickres/{id}")
	public ResponseEntity<List<Seat>> getDiscountSeats(@PathVariable("id") Long id) {
		Theater theater = theaterService.findOne(id);
		List<Seat> seatsList = seatService.findAll();
		List<Seat> seats = new ArrayList<Seat>();
		for(int i = 0; i < seatsList.size(); i++){
			if(seatsList.get(i).getHall().getDate().getPlay().getTheater().getId()==id){
				if(seatsList.get(i).getDiscount() > 0 && seatsList.get(i).getReserved().equals("slobodno"))
					seats.add(seatsList.get(i));
			}
		}
		/*for(Play play : theater.getProgram()) {
			for(DateOfPlay date : play.getDates()) {
				for(Hall hall : date.getHalls()) {
					System.out.println("hala " + hall.getName());
					for(Seat seat : hall.getSeats()) {
						System.out.println("sediste " + seat.getNumber());
						if(seat.getDiscount() > 0 && seat.getReserved().equals("slobodno")) {
							seatsList.add(seat);
						}
					}
				}
			}
		} */
		
		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);
	}
}
