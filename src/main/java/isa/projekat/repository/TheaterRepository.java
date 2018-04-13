package isa.projekat.repository;

import java.util.List;

import isa.projekat.model.Theater;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long>{

	List<Theater> findAll();
}
