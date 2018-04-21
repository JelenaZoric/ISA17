package isa.projekat.controller;

import java.util.List;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Play;
import isa.projekat.model.UserDate;
import isa.projekat.service.PlayService;
import isa.projekat.service.UserDateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/userdates")
public class UserDateController {

	@Autowired
	private UserDateService userDateService;
	
	@Autowired
	private PlayService playService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDate>> getUserDates() {
		List<UserDate> userDates = userDateService.findAll();
		return new ResponseEntity<List<UserDate>>(userDates, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/rate/{id}")
	public ResponseEntity<UserDate> updateScore(@PathVariable("id") Long id, @RequestParam("score") int score) {
		UserDate found = userDateService.findOne(id);
		found.setScore(score);
		userDateService.save(found);
		float newScore = 0;
		int sum = 0;
		int counter = 0;
		Play play = found.getDate().getPlay();
		for(DateOfPlay date : play.getDates()) {
			for(UserDate userDate : date.getUserDates()) {
				if(userDate.getScore() != 0) {
					sum += userDate.getScore();
					counter++;
				}
			}
		}
		newScore = (float)sum/counter;
		System.out.println(newScore);
		play.setAvgScore(newScore);
		playService.save(play);
		return new ResponseEntity<UserDate>(found, HttpStatus.OK);
	}
}
