package isa.projekat.service;

import java.util.List;

import isa.projekat.model.Hall;

public interface HallService {

	List<Hall> findAll();
	
	Hall findOne(Long id);
	
	Hall save(Hall hall);
}
