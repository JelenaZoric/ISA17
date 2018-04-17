package isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isa.projekat.model.Hall;
import isa.projekat.repository.HallRepository;

@Transactional
@Service
public class HallServiceImpl implements HallService{
	
	@Autowired
	private HallRepository hallRepository;

	@Override
	public List<Hall> findAll() {
		return hallRepository.findAll();
	}

	@Override
	public Hall findOne(Long id) {
		return hallRepository.findOne(id);
	}

	@Override
	public Hall save(Hall hall) {
		return hallRepository.save(hall);
	}

}
