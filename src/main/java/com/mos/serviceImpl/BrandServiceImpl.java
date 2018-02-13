package com.mos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.Brand;
import com.mos.repository.BrandRepository;
import com.mos.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public void createNewBrand(Brand brand) {
		
		brandRepository.saveAndFlush(brand);
		
	}

	@Override
	public List<Brand> findAll() {
		
		return brandRepository.findAll();
	}

	@Override
	public Brand findByBrandId(Integer brandId) {
		
		return brandRepository.findOne(brandId);
	}

}
