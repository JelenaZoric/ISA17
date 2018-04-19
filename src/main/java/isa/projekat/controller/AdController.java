package isa.projekat.controller;

import java.util.List;

import isa.projekat.model.Ad;
import isa.projekat.model.User1;
import isa.projekat.repository.AdRepository;
import isa.projekat.service.AdService;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ads")
public class AdController {

	@Autowired
	private AdService adService;
	@Autowired 
	private AdRepository adRepository;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="getAds", method = RequestMethod.GET)
	public ResponseEntity<List<Ad>> getNewAds() {

		List<Ad> ads = adService.findAll();

		return new ResponseEntity<List<Ad>>(ads, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ad> changeReservationStatus(@PathVariable Long id) {
		
		Ad ad = adService.findOne(id);
		System.out.println("KONTROLER " + ad.getName());
		ad.setReservationStatus(true);
        adService.save(ad);
		return new ResponseEntity<Ad>(ad, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Ad> addNewAd(@RequestBody Ad ad,@PathVariable Long id){
   
		User1 user = userService.findOne(id);
		System.out.println("BROJ        " + id);
		Ad ad1 = new Ad(ad.getName(),ad.getDescription(), ad.getDate(), ad.getImage(), false);
		
		user.getAd().add(ad1);
		Ad newAd = adService.save(ad1);
		userService.save(user);
		
	return new ResponseEntity<>(newAd, HttpStatus.OK);
	}
}
