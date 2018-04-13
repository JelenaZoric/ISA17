package isa.projekat.service;

import isa.projekat.model.Theater;

import java.util.List;

public interface TheaterService {
	
	List<Theater> findAll();
	
	Theater findOne(Long id);
	
	Theater save(Theater theater);
}
