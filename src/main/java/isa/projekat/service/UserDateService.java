package isa.projekat.service;

import isa.projekat.model.UserDate;

import java.util.List;

public interface UserDateService {

	List<UserDate> findAll();
	
	UserDate findOne(Long id);
	
	UserDate save(UserDate userDate);
}
