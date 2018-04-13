package isa.projekat.service;

import java.util.List;

import isa.projekat.model.Play;
import isa.projekat.repository.PlayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlayServiceImpl implements PlayService {

	@Autowired
	private PlayRepository playRepository;

	@Override
	public List<Play> findAll() {
		return playRepository.findAll();
	}

	@Override
	public Play findOne(Long id) {
		return playRepository.findOne(id);
	}

	@Override
	public Play save(Play play) {
		return playRepository.save(play);
	}
}
