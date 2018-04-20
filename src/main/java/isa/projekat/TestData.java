package isa.projekat;

import java.io.File;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import isa.projekat.model.Ad;
import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Hall;
import isa.projekat.model.Play;
import isa.projekat.model.Seat;
import isa.projekat.model.Theater;
import isa.projekat.model.User1;
import isa.projekat.repository.AdRepository;
import isa.projekat.repository.DateRepository;
import isa.projekat.service.AdService;
import isa.projekat.service.DateService;
import isa.projekat.service.HallService;
import isa.projekat.service.PlayService;
import isa.projekat.service.SeatService;
import isa.projekat.service.TheaterService;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestData {

	@Autowired
	private AdRepository dRepository;
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private PlayService playService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DateService dateService;
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private SeatService seatService;
	
	
	@PostConstruct
	private void init(){
		
		Theater t1 = new Theater("Atelje 212", "Svetogorska 21", "Beograd", "", 't');
		Theater t2 = new Theater("Narodno pozorište Kikinda", "Trg srpskih dobrovoljaca 28", "Kikinda", "", 't');
		
		theaterService.save(t1);
		theaterService.save(t2);
		
		Play p1 = new Play("Pomorandžina kora", "drama", "Goran Marković", 93, 3.4f, "", 400, t1);
		Play p2 = new Play("Smrt čoveka na Balkanu", "komedija", "Miroslav Momčilović", 100, 3.9f, "", 100, t2);
		Play p3 = new Play("Kauboji", "mjuzikl", "Kokan Mladenović", 90, 4.2f, "", 300, t2);
		
		playService.save(p1);
		playService.save(p2);
		playService.save(p3);
		
		DateOfPlay date1 = new DateOfPlay("2018-04-20", p1);
		DateOfPlay date2 = new DateOfPlay("2018-04-21", p1);
		DateOfPlay date3 = new DateOfPlay("2018-04-22", p2);
		DateOfPlay date5 = new DateOfPlay("2018-04-18", p2);
		DateOfPlay date4 = new DateOfPlay("2018-04-23", p3);
		
		dateService.save(date1);
		dateService.save(date2);
		dateService.save(date3);
		dateService.save(date4);
		dateService.save(date5);
		
		Hall hall1 = new Hall("sala A", 10, date1);
		Hall hall2 = new Hall("sala B", 15, date1);
		Hall hall3 = new Hall("sala C", 12, date2);
		Hall hall4 = new Hall("sala D", 20, date3);
		Hall hall5 = new Hall("sala E", 20, date5);
		
		hallService.save(hall1);
		hallService.save(hall2);
		hallService.save(hall3);
		hallService.save(hall4);
		hallService.save(hall5);
		
		Seat seat1 = new Seat(1, "slobodno", 30, hall1);
		Seat seat2 = new Seat(2, "slobodno", 20, hall1);
		Seat seat3 = new Seat(3, "slobodno", hall1);
		Seat seat4 = new Seat(4, "slobodno", hall1);
		Seat seat5 = new Seat(5, "slobodno", hall1);
		
		Seat seat6 = new Seat(6, "slobodno", 40, hall4);
		Seat seat7 = new Seat(7, "slobodno", hall4);
		Seat seat8 = new Seat(8, "slobodno", 15, hall4);
		Seat seat9 = new Seat(9, "slobodno", hall4);
		
		Seat seat10 = new Seat(10, "slobodno", 3, hall5);
		Seat seat11 = new Seat(11, "slobodno", hall5);
		Seat seat12 = new Seat(12, "slobodno", 22, hall5);
		Seat seat13 = new Seat(13, "slobodno", hall5);
		
		seatService.save(seat1);
		seatService.save(seat2);
		seatService.save(seat3);
		seatService.save(seat4);
		seatService.save(seat5);
		seatService.save(seat6);
		seatService.save(seat7);
		seatService.save(seat8);
		seatService.save(seat9);
		seatService.save(seat10);
		seatService.save(seat11);
		seatService.save(seat12);
		seatService.save(seat13);	
	
		@SuppressWarnings("deprecation")
		Date date = new Date(1200, 12, 1);
		File file = new File("C:\\Users\\Violeta\\Desktop\\primer.jpg");
		Ad ad = new Ad("oglasss", "opis", date, file, true);
		adService.save(ad);
		
	    System.out.println(adService.findAll()+ "ISPISI SACUVANE" );
	    Ad ad1 = new Ad("oglasss", "opis");
		adService.save(ad1);
	}
}
