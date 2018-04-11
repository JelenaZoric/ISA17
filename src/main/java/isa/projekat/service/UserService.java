package isa.projekat.service;

import java.util.List;

import isa.projekat.model.User1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	Page<User1> findUsers(String criteria, Pageable pageable);

	User1 findOne(Long id);
	
	User1 getUser(String email, String password);
	
	List<User1> findAll();
	
	User1 save(User1 user);
	
	List<User1> save(List<User1> users);
}
