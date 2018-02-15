package com.mos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.Country;
import com.mos.repository.CountryRepository;
import com.mos.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	public CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll() {
		
		return countryRepository.findAll();
	}

}
