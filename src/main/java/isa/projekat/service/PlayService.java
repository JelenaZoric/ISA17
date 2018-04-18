package isa.projekat.service;

import isa.projekat.model.Play;

import java.util.List;

public interface PlayService {

	List<Play> findAll();
	
	Play findOne(Long id);
	
	Play save(Play play);
	
	Play delete(Long id);
}
