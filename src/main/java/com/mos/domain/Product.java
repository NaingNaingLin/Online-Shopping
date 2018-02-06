package com.mos.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide Product Code!")
	private String productCode;
	
	@NotEmpty(message = "Please provide Quantity!")
	@Length(min = 1, max = 100000, message = "Please provide Quantity Range Between 1 and 100,000")
	private int quantity;
	
	@NotEmpty(message = "Please provide Unit Price!")
	private double unitPrice;
	
	@JoinColumn(name="Company_Id", referencedColumnName="id")
	@ManyToOne
	private Company companyId;
	
	@JoinColumn(name="Brand_Id", referencedColumnName="id")
	@ManyToOne
	private Brand brandId;
	
	@JoinColumn(name="Category_Id", referencedColumnName="id")
	@ManyToOne
	private Category categoryId;
	
	@OneToMany(mappedBy="productId")
	private Collection<ProductDetail> productDetailCollection;
	
	@OneToMany(mappedBy="productId")
	private Collection<PromotionDetail> promotionDetailCollection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	public Brand getBrandId() {
		return brandId;
	}

	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Collection<ProductDetail> getProductDetailCollection() {
		return productDetailCollection;
	}

	public void setProductDetailCollection(Collection<ProductDetail> productDetailCollection) {
		this.productDetailCollection = productDetailCollection;
	}

	public Collection<PromotionDetail> getPromotionDetailCollection() {
		return promotionDetailCollection;
	}

	public void setPromotionDetailCollection(Collection<PromotionDetail> promotionDetailCollection) {
		this.promotionDetailCollection = promotionDetailCollection;
	}
	
	
}
