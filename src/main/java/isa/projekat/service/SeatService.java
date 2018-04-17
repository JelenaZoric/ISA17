package isa.projekat.service;

import java.util.List;

import isa.projekat.model.Seat;

public interface SeatService {

	List<Seat> findAll();
	
	Seat findOne(Long id);
	
	Seat save(Seat seat);
}
