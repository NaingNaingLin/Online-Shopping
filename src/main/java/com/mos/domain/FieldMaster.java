package com.mos.domain;

import java.io.Serializable;
import java.util.Collection;

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
	private int id;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide field Code!")
	private String fieldCode;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide field Name!")
	private String fieldName;

	@OneToMany(mappedBy= "fieldId")
	private Collection<ProductDetail> productDetailCollection;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Collection<ProductDetail> getProductDetailCollection() {
		return productDetailCollection;
	}

	public void setProductDetailCollection(Collection<ProductDetail> productDetailCollection) {
		this.productDetailCollection = productDetailCollection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldCode == null) ? 0 : fieldCode.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + id;
		result = prime * result + ((productDetailCollection == null) ? 0 : productDetailCollection.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldMaster other = (FieldMaster) obj;
		if (fieldCode == null) {
			if (other.fieldCode != null)
				return false;
		} else if (!fieldCode.equals(other.fieldCode))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (id != other.id)
			return false;
		if (productDetailCollection == null) {
			if (other.productDetailCollection != null)
				return false;
		} else if (!productDetailCollection.equals(other.productDetailCollection))
			return false;
		return true;
	}

	
	
}
