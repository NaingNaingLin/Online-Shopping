package com.mos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mos.domain.Brand;
import com.mos.service.BrandService;

@Controller
//@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping("/list")
	public ModelAndView showList(Model model) {
		
		model.addAttribute("brand", new Brand());
		
		ModelAndView modelandview = new ModelAndView();
		
		List<Brand> brandList = new ArrayList<>();
		brandList = brandService.findAll();
		
		modelandview.addObject("brandList", brandList);
		modelandview.setViewName("admin/views/brands");
		
		return modelandview;
	}
	
	@GetMapping("/add")
	public ModelAndView addBrand(Model model) {
		
		ModelAndView modelandview = new ModelAndView();
		
		model.addAttribute("brand", new Brand());
		
		List<Brand> brandList = new ArrayList<>();
		brandList = brandService.findAll();
		
		modelandview.addObject("brandList", brandList);
		modelandview.setViewName("admin/views/brand");
		
		return modelandview;
	}
	
	@PostMapping("/add")
	public ModelAndView addBrand(@ModelAttribute("brand") Brand brand) {
		
		ModelAndView modelandview = new ModelAndView();
		
		brandService.createNewBrand(brand);		
		modelandview.setViewName("redirect:/list");
		
		return modelandview;
	}
}
