package com.mos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.Product;
import com.mos.repository.ProductRepository;
import com.mos.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService  {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public void createProduct(Product product) {
		
		productRepository.saveAndFlush(product);
		
	}
	
	

}
