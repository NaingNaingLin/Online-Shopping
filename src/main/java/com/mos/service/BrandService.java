package com.mos.service;

import java.util.List;

import com.mos.domain.Brand;

public interface BrandService {
	void createNewBrand(Brand brand);
	void editBrand(Brand brand);
	void deleteByBrandId(Integer brandId);
	List<Brand> findAll();
	Brand findByBrandId(Integer brandId);

}
