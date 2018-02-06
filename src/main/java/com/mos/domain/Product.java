package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int productId;
	
	@Size(max = 50)
	@NotEmpty(message = "Please provide Product Code!")
	private String productCode;
	
	@NotEmpty(message = "Please provide Quantity!")
	@Length(min = 1, max = 100000, message = "Please provide Quantity Range Between 1 and 100,000")
	private int quantity;
	
	@NotEmpty(message = "Please provide Unit Price!")
	private double unitPrice;
	

	@ManyToOne
	private Company companyId;
	

	@ManyToOne
	private Brand brandId;
	

	@ManyToOne
	private Category categoryId;
	
	@OneToMany(mappedBy="productId")
	private List<ProductDetail> productDetailCollection = new ArrayList<>();
	
	@OneToMany(mappedBy="productId")
	private List<PromotionDetail> promotionDetailCollection = new ArrayList<>();
	
	@OneToMany(mappedBy="productId")
	private List<PurchaseDetail> purchaseDetailCollection = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return productId;
	}

	public void setId(int productId) {
		this.productId = productId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<ProductDetail> getProductDetailCollection() {
		return productDetailCollection;
	}

	public void setProductDetailCollection(List<ProductDetail> productDetailCollection) {
		this.productDetailCollection = productDetailCollection;
	}

	public List<PromotionDetail> getPromotionDetailCollection() {
		return promotionDetailCollection;
	}

	public void setPromotionDetailCollection(List<PromotionDetail> promotionDetailCollection) {
		this.promotionDetailCollection = promotionDetailCollection;
	}

	public List<PurchaseDetail> getPurchaseDetailCollection() {
		return purchaseDetailCollection;
	}

	public void setPurchaseDetailCollection(List<PurchaseDetail> purchaseDetailCollection) {
		this.purchaseDetailCollection = purchaseDetailCollection;
	}

	
}
