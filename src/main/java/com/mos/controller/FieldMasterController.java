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

import com.mos.domain.FieldMaster;
import com.mos.service.FieldMasterService;

@Controller
public class FieldMasterController {

	@Autowired
	private FieldMasterService fieldMasterService;
	
	@GetMapping("/fieldMaster/add")
	public String addFieldMaster(Model model) {
		
		model.addAttribute("fieldMaster", new FieldMaster());
		
		List<FieldMaster> fieldMasterList = new ArrayList<>();
		fieldMasterList = fieldMasterService.findAll();
		model.addAttribute("fieldMasterList", fieldMasterList);
		
		return "fieldMaster";
	}
	
	@PostMapping("/fieldMaster/add")
	public String addFieldMaster(@ModelAttribute("fieldMaster") @Valid FieldMaster fieldMaster) {
		
		fieldMasterService.createFieldMaster(fieldMaster);
		
		return "redirect:/list";
	}
	
	@GetMapping("/fieldMaster/edit/{fieldMasterId}")
	public String updateFieldMaster(Model model, @PathVariable("fieldMasterId") Integer fieldMasterId) {
		
		model.addAttribute("updatedFieldMaster", fieldMasterService.findByFieldId(fieldMasterId));
		
		return "editFieldMaster";
	}
	
	@PostMapping("/fieldMaster/edit/{fieldMasterId}")
	public String updateFieldMaster(@ModelAttribute("updatedFieldMaster") @Valid FieldMaster updatedFieldMaster, @PathVariable("fieldMasterId") Integer fieldMasterId){
		
		FieldMaster existedFieldMaster = fieldMasterService.findByFieldId(fieldMasterId);
		existedFieldMaster.setFieldCode(updatedFieldMaster.getFieldCode());
		existedFieldMaster.setFieldName(updatedFieldMaster.getFieldName());
		
		fieldMasterService.editFieldMaster(existedFieldMaster);
		
		return "redirect:/list";
	}
	
	@GetMapping("/fieldMaster/list")
	public String listAllFieldMaster(Model model) {
		
		List<FieldMaster> fieldMasterList = new ArrayList<>();
		fieldMasterList = fieldMasterService.findAll();
		
		model.addAttribute("fieldMasterList", fieldMasterList);
		
		return "fieldMasters";
	}
	
	@PostMapping("/delete/{fieldMasterId}")
	public String deleteFieldMaster(@PathVariable("fieldMasterId") Integer fieldMasterId) {
		
		fieldMasterService.deleteByFieldId(fieldMasterId);
		
		return "redirect:/list";
	}
	
}
