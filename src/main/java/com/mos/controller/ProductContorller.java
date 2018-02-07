package com.mos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductContorller {
	@RequestMapping("/products")
	public String productPage() {
		return "products";
	}

}
