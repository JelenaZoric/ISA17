package isa.projekat.controller;

import isa.projekat.model.Play;
import isa.projekat.repository.PlayRepository;
import isa.projekat.service.PlayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="plays")
public class PlayController {

	@Autowired
	private PlayService playService;
	
	@Autowired
	private PlayRepository playRepository;
	
	@RequestMapping(value="getPlay", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Play> getPlay(@RequestParam("id") Long id) {
		Play play = playService.findOne(id);
		return new ResponseEntity<Play>(play, HttpStatus.OK);
	}
}
