package com.mos.service;

import java.util.List;

import com.mos.domain.Brand;

public interface BrandService {
	void createNewBrand(Brand brand);
	List<Brand> findAll();
	Brand findByBrandId(Integer brandId);
}
