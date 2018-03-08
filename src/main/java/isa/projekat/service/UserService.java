package isa.projekat.service;

import isa.projekat.model.User1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	Page<User1> findUsers(String criteria, Pageable pageable);

	User1 getUser(String name, String lastname);
}
