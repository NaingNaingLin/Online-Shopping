package com.mos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mos.domain.Product;
import com.mos.service.ProductService;

@Controller
public class ProductContorller {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product")
	public String productPage(Model model) {
		model.addAttribute("product" , new Product());
		return "productForm";
	}

}
