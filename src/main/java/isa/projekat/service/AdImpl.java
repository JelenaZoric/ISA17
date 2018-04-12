package isa.projekat.service;

import java.util.List;

import isa.projekat.model.Ad;
import isa.projekat.model.Theater;
import isa.projekat.repository.AdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.joran.action.NewRuleAction;


@Transactional
@Service
public class AdImpl implements AdService{
    
	@Autowired
	private AdRepository newAdRepository;

	@Override
	public List<Ad> findAll() {
		return newAdRepository.findAll();
	}

	@Override
	public Ad save(Ad ad) {
		// TODO Auto-generated method stub
		return newAdRepository.save(ad);
	}

	@Override
	public List<Ad> save(List<Ad> ads) {
		// TODO Auto-generated method stub
		return newAdRepository.save(ads);
	}

	@Override
	public Ad findOne(Long id) {
		// TODO Auto-generated method stub
		return newAdRepository.findOne(id);
	}


	
}
