package isa.projekat.repository;

import java.util.List;

import isa.projekat.model.Theater;

import org.springframework.data.repository.Repository;

public interface TheaterRepository extends Repository<Theater, Long>{

	List<Theater> findAll();
}
