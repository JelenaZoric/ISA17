package isa.projekat.repository;

import java.util.List;

import isa.projekat.model.User1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User1, Long> {
	Page<User1> findAll(Pageable pageable);
	
	List<User1> findByName(String name);

	Page<User1> findByNameContainingAndLastnameContainingAllIgnoringCase(String name,
			String lastname, Pageable pageable);

	User1 findByNameAndLastnameAllIgnoringCase(String name, String lastname);
}
