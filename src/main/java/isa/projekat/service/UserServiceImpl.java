package isa.projekat.service;

import java.util.List;

import isa.projekat.model.User1;
import isa.projekat.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User1> findUsers(String criteria, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User1 findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User1> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User1 save(User1 user) {
		return userRepository.save(user);
	}

	@Override
	public List<User1> save(List<User1> users) {
		return userRepository.save(users);
	}



}
