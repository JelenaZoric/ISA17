package isa.projekat.service;

import java.util.List;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Play;

public interface DateService {

	List<DateOfPlay> findAll();
	
	DateOfPlay findOne(Long id);
	
	DateOfPlay save(DateOfPlay date);
}
