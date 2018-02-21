package com.mos.service;

import java.util.List;

import com.mos.domain.FieldMaster;

public interface FieldMasterService {

	void createFieldMaster(FieldMaster fieldMaster);
	void editFieldMaster(FieldMaster fieldMaster);
	void deleteByFieldId(Integer fieldId);
	List<FieldMaster> findAll();
	FieldMaster findByFieldName(String fieldName);
	FieldMaster findByFieldCode(String fieldCode);
	FieldMaster findByFieldId(Integer fieldId);
}
