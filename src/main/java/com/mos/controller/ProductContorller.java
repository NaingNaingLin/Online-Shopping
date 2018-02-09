package com.mos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mos.domain.Product;
import com.mos.service.ProductService;

@Controller
public class ProductContorller {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public String productForm(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute Product product) {
		productService.createProduct(product);
		return "result";
	}

}
