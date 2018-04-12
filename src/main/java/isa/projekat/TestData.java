package isa.projekat;

import java.io.File;
import java.sql.Date;

import javax.annotation.PostConstruct;

import isa.projekat.model.Ad;
import isa.projekat.model.User1;
import isa.projekat.repository.AdRepository;
import isa.projekat.service.AdService;
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
	private UserService userService;
	
	
	@PostConstruct
	private void init(){
	
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
