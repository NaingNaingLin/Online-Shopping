package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FieldMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fieldMasterId;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide field Code!")
	private String fieldCode;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide field Name!")
	private String fieldName;

	@OneToMany(mappedBy= "fieldId")
	private List<ProductDetail> productDetailList = new ArrayList<>();
	
	public FieldMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return fieldMasterId;
	}

	public void setId(int fieldMasterId) {
		this.fieldMasterId = fieldMasterId;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getFieldMasterId() {
		return fieldMasterId;
	}

	public void setFieldMasterId(int fieldMasterId) {
		this.fieldMasterId = fieldMasterId;
	}

	public List<ProductDetail> getProductDetailList() {
		return productDetailList;
	}

	public void setProductDetailList(List<ProductDetail> productDetailList) {
		this.productDetailList = productDetailList;
	}


	
}
