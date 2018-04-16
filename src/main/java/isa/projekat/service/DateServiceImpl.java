package isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isa.projekat.model.DateOfPlay;
import isa.projekat.repository.DateRepository;

@Transactional
@Service
public class DateServiceImpl implements DateService{
	
	@Autowired
	private DateRepository dateRepository;

	@Override
	public List<DateOfPlay> findAll() {
		return dateRepository.findAll();
	}

	@Override
	public DateOfPlay findOne(Long id) {
		return dateRepository.findOne(id);
	}

	@Override
	public DateOfPlay save(DateOfPlay date) {
		return dateRepository.save(date);
	}

}
