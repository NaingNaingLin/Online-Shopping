package com.mos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FavouriteProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int favouriteProductId;
	

	@ManyToOne
	@JoinColumn(name="Customer_Id")
	private Customer customerId;
	

	@ManyToOne
	@JoinColumn(name="ProductDetail_Id")
	private ProductDetail productDetailId;
	
	@Temporal(TemporalType.DATE)
	private Date favouriteDate;
	
	public FavouriteProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFavouriteProductId() {
		return favouriteProductId;
	}

	public void setFavouriteProductId(int favouriteProductId) {
		this.favouriteProductId = favouriteProductId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public ProductDetail getProductDetailId() {
		return productDetailId;
	}

	public void setProductDetailId(ProductDetail productDetailId) {
		this.productDetailId = productDetailId;
	}

	public Date getFavouriteDate() {
		return favouriteDate;
	}

	public void setFavouriteDate(Date favouriteDate) {
		this.favouriteDate = favouriteDate;
	}
	
	
}
