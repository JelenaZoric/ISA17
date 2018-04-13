package isa.projekat.service;

import isa.projekat.model.Theater;
import isa.projekat.repository.TheaterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;

	@Override
	public List<Theater> findAll() {
		return theaterRepository.findAll();
	}
	
	@Override
	public Theater findOne(Long id) {
		return theaterRepository.findOne(id);
	}

	@Override
	public Theater save(Theater theater) {
		return theaterRepository.save(theater);
	}
}
