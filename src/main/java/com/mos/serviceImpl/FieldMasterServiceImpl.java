package com.mos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.FieldMaster;
import com.mos.repository.FieldMasterRepository;
import com.mos.service.FieldMasterService;

@Service
public class FieldMasterServiceImpl implements FieldMasterService{

	@Autowired
	private FieldMasterRepository fieldMasterRepository;
	
	@Override
	public void createFieldMaster(FieldMaster fieldMaster) {
		
		fieldMasterRepository.saveAndFlush(fieldMaster);
	}

	@Override
	public void editFieldMaster(FieldMaster fieldMaster) {
	
		fieldMasterRepository.save(fieldMaster);
	}

	@Override
	public void deleteByFieldId(Integer fieldId) {
		
		fieldMasterRepository.delete(fieldId);
	}
	
	@Override
	public List<FieldMaster> findAll() {
		
		return fieldMasterRepository.findAll();
	}

	@Override
	public FieldMaster findByFieldName(String fieldName) {
		
		return fieldMasterRepository.findByFieldName(fieldName);
	}

	@Override
	public FieldMaster findByFieldCode(String fieldCode) {
		
		return fieldMasterRepository.findByFieldCode(fieldCode);
	}

	@Override
	public FieldMaster findByFieldId(Integer fieldId) {
		
		return fieldMasterRepository.findOne(fieldId);
	}

	

}
