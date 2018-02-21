package com.mos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mos.domain.Brand;
import com.mos.domain.Country;
import com.mos.service.BrandService;
import com.mos.service.CountryService;

@Controller
//@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/list")
	public ModelAndView showList(Model model) {
		
		model.addAttribute("brand", new Brand());
		
		ModelAndView modelandview = new ModelAndView();
		
		List<Brand> brandList = new ArrayList<>();
		brandList = brandService.findAll();
		
		modelandview.addObject("brandList", brandList);
		modelandview.setViewName("admin/views/brand/brandList");
		
		return modelandview;
	}
	
	@GetMapping("/add")
	public ModelAndView addBrand(Model model) {
		
		ModelAndView modelandview = new ModelAndView();
		
		model.addAttribute("brand", new Brand());
		
		List<Brand> brandList = new ArrayList<>();
		brandList = brandService.findAll();
		
		List<Country> countryList = new ArrayList<>();
		countryList = countryService.findAll();
		
		modelandview.addObject("brandList", brandList);
		modelandview.addObject("countryList", countryList);
		modelandview.setViewName("admin/views/brand/addBrand");
		
		return modelandview;
	}
	
	@PostMapping("/add")
	public ModelAndView addBrand(@ModelAttribute("brand") @Valid Brand brand, RedirectAttributes redirectAttributes) {

		ModelAndView modelandview = new ModelAndView();
		
		brandService.createNewBrand(brand);
		redirectAttributes.addFlashAttribute("lastaction", "Successfully Added!");
		modelandview.setViewName("redirect:/list");
		
		return modelandview;
	}
	
	@GetMapping("/edit/{brandId}")
	public String editBrand(@PathVariable("brandId") Integer brandId, Model model) {
		
		model.addAttribute("updatedBrand", brandService.findByBrandId(brandId));
		
		return "admin/views/brand/editBrand";
	}
	
	@PostMapping("/edit/{brandId}")
	public ModelAndView editBrand(@PathVariable("brandId") Integer brandId, @ModelAttribute("updatedBrand") @Valid Brand updatedBrand) {
		
		Brand existedBrand = brandService.findByBrandId(brandId);
		existedBrand.setBrandCode(updatedBrand.getBrandCode());
		existedBrand.setName(updatedBrand.getName());
		existedBrand.setCountry(updatedBrand.getCountry());
		existedBrand.setDescription(updatedBrand.getDescription());
		
		brandService.editBrand(existedBrand);
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("redirect:/list");
		return modelandview;
	}
	
	@RequestMapping("/delete/{brandId}")
	public ModelAndView deleteBrand(@PathVariable("brandId") Integer brandId) {
		
		ModelAndView modelandview = new ModelAndView();
		
		brandService.deleteByBrandId(brandId);

		modelandview.setViewName("redirect:/list");
		
		return modelandview;
	}
}
