package com.mos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class ProductDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productDetailId;
	

	@ManyToOne
	@JoinColumn(name="Product_Id")
	private Product productId;
	

	@ManyToOne
	@JoinColumn(name="Field_Id")
	private FieldMaster fieldId;
	
	@Size(max = 300)
	private String description;
	
	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return productDetailId;
	}

	public void setId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public FieldMaster getFieldId() {
		return fieldId;
	}

	public void setFieldId(FieldMaster fieldId) {
		this.fieldId = fieldId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
