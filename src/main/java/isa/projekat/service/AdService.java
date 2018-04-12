package isa.projekat.service;


import isa.projekat.model.Ad;

import java.util.List;

public interface AdService {

	List<Ad> findAll();
 
	Ad findOne(Long id);
	
	Ad save(Ad ad);
	
	List<Ad> save(List<Ad> ads);
}
