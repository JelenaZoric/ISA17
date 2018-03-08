package isa.projekat.service;

import isa.projekat.model.User1;
import isa.projekat.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User1> findUsers(String criteria, Pageable pageable) {
		Assert.notNull(criteria, "Kriterijum ne sme biti null");

		if (!StringUtils.hasLength(criteria)) {
			return this.userRepository.findAll(null);
		}

		String lastname = "";
		int splitPos = criteria.lastIndexOf(",");

		if (splitPos >= 0) {
			lastname = criteria.substring(splitPos + 1);
			criteria = criteria.substring(0, splitPos);
		}

		return this.userRepository
				.findByNameContainingAndLastnameContainingAllIgnoringCase(criteria.trim(),
						lastname.trim(), pageable);
	}

	public User1 getUser(String name, String lastname) {
		Assert.notNull(name, "Ime ne sme biti null");
		Assert.notNull(lastname, "Prezime ne sme biti null");
		return this.userRepository.findByNameAndLastnameAllIgnoringCase(name, lastname);
	}
    





}
