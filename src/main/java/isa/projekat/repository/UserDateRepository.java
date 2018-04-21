package isa.projekat.repository;

import isa.projekat.model.UserDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDateRepository extends JpaRepository<UserDate, Long> {

}
