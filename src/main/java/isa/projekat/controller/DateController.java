package isa.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.projekat.model.DateOfPlay;
import isa.projekat.repository.DateRepository;
import isa.projekat.service.DateService;

@RestController
@RequestMapping(value="dates")
public class DateController {

	@Autowired
	private DateService dateService;
	
	@Autowired
	private DateRepository dateRepository;
	
	@RequestMapping(value="getDate", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DateOfPlay> getDate(@RequestParam("id") Long id) {
		DateOfPlay date = dateService.findOne(id);
		return new ResponseEntity<DateOfPlay>(date, HttpStatus.OK);
	}
}
