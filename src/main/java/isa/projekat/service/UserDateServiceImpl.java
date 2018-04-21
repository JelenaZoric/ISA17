package isa.projekat.service;

import java.util.List;

import isa.projekat.model.UserDate;
import isa.projekat.repository.UserDateRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UserDateServiceImpl implements UserDateService {

	@Autowired
	private UserDateRepository userDateRepository;
	
	@Override
	public List<UserDate> findAll() {
		return userDateRepository.findAll();
	}

	@Override
	public UserDate findOne(Long id) {
		return userDateRepository.findOne(id);
	}

	@Override
	public UserDate save(UserDate userDate) {
		return userDateRepository.save(userDate);
	}
}
