package isa.projekat;

import java.io.File;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import isa.projekat.model.Ad;
import isa.projekat.model.Play;
import isa.projekat.model.Theater;
import isa.projekat.repository.AdRepository;
import isa.projekat.service.AdService;
import isa.projekat.service.PlayService;
import isa.projekat.service.TheaterService;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestData {

	@Autowired
	private AdRepository newAdRepository;
	
	@Autowired
	private AdService newAdService;
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private PlayService playService;
	
	@Autowired
	private UserService userService;
	
	
	@PostConstruct
	private void init(){
		Play p1 = new Play("Pomorandžina kora", "drama", "Goran Marković", 93, 3.4f, "", 400);
		Play p2 = new Play("Smrt čoveka na Balkanu", "komedija", "Miroslav Momčilović", 100, 3.9f, "", 300);
		Play p3 = new Play("Kauboji", "mjuzikl", "Kokan Mladenović", 90, 4.2f, "", 300);
		//p1.setTheater(t1);
		//t1.getProgram().add(p1);
		Set<Play> plays = new HashSet<Play>();
		plays.add(p1);
		Set<Play> plays2 = new HashSet<Play>();
		plays2.add(p2);
		plays2.add(p3);
		Theater t1 = new Theater("Atelje 212", "Svetogorska 21", "Beograd", "", 't', plays);
		Theater t2 = new Theater("Narodno pozorište Kikinda", "Trg srpskih dobrovoljaca 28", "Kikinda", "", 't', plays2);
		t1 = theaterService.save(t1);
		theaterService.save(t2);
	
		@SuppressWarnings("deprecation")
		Date date = new Date(1200, 12, 1);
		File file = new File("C:\\Users\\Violeta\\Desktop\\primer.jpg");
		Ad ad = new Ad("oglasss", "opis", date, file, true);
		newAdService.save(ad);
		
	    System.out.println(newAdService.findAll()+ "ISPISI SACUVANE" );
	    Ad ad1 = new Ad("oglasss", "opis");
		newAdService.save(ad1);
	}
}
