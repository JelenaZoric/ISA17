package isa.projekat.controller;

import isa.projekat.model.Play;
import isa.projekat.model.Theater;
import isa.projekat.repository.PlayRepository;
import isa.projekat.repository.TheaterRepository;
import isa.projekat.service.PlayService;
import isa.projekat.service.TheaterService;

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

@RestController
@RequestMapping(value="plays")
public class PlayController {

	@Autowired
	private PlayService playService;
	
	@Autowired
	private PlayRepository playRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping(value="getPlay", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Play> getPlay(@RequestParam("id") Long id) {
		Play play = playService.findOne(id);
		return new ResponseEntity<Play>(play, HttpStatus.OK);
	}
	
	//dodavanje predstave
	@RequestMapping(value="/{theater_id}",method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Play> add(@RequestBody Play play, @PathVariable("theater_id") Long theater_id) {
		Play newPlay = playService.save(play);
		Theater theater = theaterService.findOne(theater_id);
		theater.getProgram().add(play);
		System.out.println("program " + theater.getProgram());
		theaterService.save(theater);
		System.out.println("id poz " + theater.getId());
		return new ResponseEntity<Play>(newPlay, HttpStatus.CREATED);
	}
	
	//izmena
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Play> edit(@PathVariable("id") Long id, @RequestBody Play play) {
		Play edited = playService.findOne(id);
		edited.setName(play.getName());
		edited.setGenre(play.getGenre());
		edited.setDirector(play.getDirector());
		edited.setDuration(play.getDuration());
		edited.setAvgScore(play.getAvgScore());
		edited.setPrice(play.getPrice());
		edited.setDescription(play.getDescription());
		playService.save(edited);
		return new ResponseEntity<Play>(edited, HttpStatus.OK);
	}
		
	//brisanje predstave
	@RequestMapping(value="/{theater_id}/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Play> remove(@PathVariable("id") Long id, @PathVariable("theater_id") Long theater_id) {
		Theater theater = theaterService.findOne(theater_id);
		Play deleted = playService.findOne(id);
		theater.getProgram().remove(deleted);
		theaterService.save(theater);
		System.out.println("obrisao");
		return new ResponseEntity<Play>(deleted, HttpStatus.NO_CONTENT);
	}
}
