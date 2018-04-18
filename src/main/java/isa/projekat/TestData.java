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
	private AdRepository newAdRepository;
	
	@Autowired
	private AdService newAdService;
	
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
		
		Set<Seat>seats1 = new HashSet<Seat>();
		Set<Seat>seats2 = new HashSet<Seat>();
		
		Seat seat1 = new Seat(1, "slobodno", 30);
		Seat seat2 = new Seat(2, "slobodno", 20);
		Seat seat3 = new Seat(3, "slobodno");
		Seat seat4 = new Seat(4, "slobodno");
		Seat seat5 = new Seat(5, "slobodno");
		
		Seat seat6 = new Seat(1, "slobodno");
		Seat seat7 = new Seat(2, "slobodno");
		Seat seat8 = new Seat(3, "slobodno");
		Seat seat9 = new Seat(4, "slobodno");
		
		seats1.add(seat1);
		seats1.add(seat2);
		seats1.add(seat3);
		seats1.add(seat4);
		seats1.add(seat5);
		
		seats2.add(seat6);
		seats2.add(seat7);
		seats2.add(seat8);
		seats2.add(seat9);
		
		seatService.save(seat1);
		seatService.save(seat2);
		seatService.save(seat3);
		seatService.save(seat4);
		seatService.save(seat5);
		seatService.save(seat6);
		seatService.save(seat7);
		seatService.save(seat8);
		seatService.save(seat9);
		
		Set<Hall>halls1 = new HashSet<Hall>();
		//Set<Hall>halls2 = new HashSet<Hall>();
		//Set<Hall>halls3 = new HashSet<Hall>();
		
		Hall hall1 = new Hall(seats1, "sala A", 10);
		Hall hall2 = new Hall(seats2, "sala B", 15);
		//Hall hall3 = new Hall(new HashSet<Seat>(), "sala C", 12);
		//Hall hall4 = new Hall(new HashSet<Seat>(), "sala D", 20);
		//Hall hall5 = new Hall(new HashSet<Seat>(), "sala E", 8);
		
		halls1.add(hall1);
		halls1.add(hall2);
		//halls1.add(hall3);
		//halls2.add(hall4);
		//halls2.add(hall5);
		hallService.save(hall1);
		hallService.save(hall2);
		//hallService.save(hall3);
		//hallService.save(hall4);
		//hallService.save(hall5);
		
		
		Set<DateOfPlay> dates1 = new HashSet<DateOfPlay>();
		Set<DateOfPlay> dates2 = new HashSet<DateOfPlay>();
		//Set<Hall>halls = new HashSet<>();
		DateOfPlay date1 = new DateOfPlay("1.1.2019. 20h", halls1);
		DateOfPlay date2 = new DateOfPlay("2.1.2019. 19h", new HashSet<Hall>());
		DateOfPlay date3 = new DateOfPlay("3.1.2019. 21h", new HashSet<Hall>());
		DateOfPlay date4 = new DateOfPlay("4.1.2019. 16h", new HashSet<Hall>());
		dates1.add(date1);
		dates1.add(date2);
		dates2.add(date3);
		dates2.add(date4);
		dateService.save(date1);
		dateService.save(date2);
		dateService.save(date3);
		dateService.save(date4);
		Play p1 = new Play("Pomorandžina kora", "drama", "Goran Marković", 93, 3.4f, "", 400, dates1);
		Play p2 = new Play("Smrt čoveka na Balkanu", "komedija", "Miroslav Momčilović", 100, 3.9f, "", 300, dates1);
		Play p3 = new Play("Kauboji", "mjuzikl", "Kokan Mladenović", 90, 4.2f, "", 300, dates2);
		//p1.setTheater(t1);
		//t1.getProgram().add(p1);
		//playService.save(p1);
	//	playService.save(p2);
	//	playService.save(p3);
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
