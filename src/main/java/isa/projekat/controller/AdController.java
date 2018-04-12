package isa.projekat.controller;

import java.util.List;

import isa.projekat.model.Ad;
import isa.projekat.repository.AdRepository;
import isa.projekat.service.AdService;

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
	private AdService newAdService;
	@Autowired 
	private AdRepository newAdRepository;
	
	@RequestMapping(value="getAds", method = RequestMethod.GET)
	public ResponseEntity<List<Ad>> getNewAds() {

		List<Ad> ads = newAdService.findAll();

		return new ResponseEntity<List<Ad>>(ads, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ad> changeReservationStatus(@PathVariable Long id) {
		
		Ad ad = newAdService.findOne(id);
		System.out.println("KONTROLER " + ad.getName());
		ad.setReservationStatus(true);
        newAdService.save(ad);
		return new ResponseEntity<Ad>(ad, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Ad> addNewAd(@RequestBody Ad ad){
		System.out.println("IDDDDD " + ad.getId());
		System.out.println("NAME " + ad.getName());
		Ad ad1 = new Ad(ad.getName(),ad.getDescription(), ad.getDate(), ad.getImage(), true);
		//System.out.println("IDDDDDD"  + newAdService.findOne(ad.getId()));
	Ad newAd = newAdService.save(ad1);
	//System.out.println(newAdService.findOne(ad.getId()).toString() + "PRONADJENO");
	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA VISEEEEEEEEEEEEEEEEEE");
	//HttpHeaders headers = new HttpHeaders();
	//headers.setLocation(URI.create("http://localhost:8090/myapp/funZona.html"));
	return new ResponseEntity<>(newAd, HttpStatus.OK);
	}
}
