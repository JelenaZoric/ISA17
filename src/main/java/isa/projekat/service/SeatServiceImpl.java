package isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isa.projekat.model.Seat;
import isa.projekat.repository.SeatRepository;

@Transactional
@Service
public class SeatServiceImpl implements SeatService{
	
	@Autowired
	private SeatRepository seatRepository;

	@Override
	public List<Seat> findAll() {
		return seatRepository.findAll();
	}

	@Override
	public Seat findOne(Long id) {
		return seatRepository.findOne(id);
	}

	@Override
	public Seat save(Seat seat) {
		return seatRepository.save(seat);
	}

}
