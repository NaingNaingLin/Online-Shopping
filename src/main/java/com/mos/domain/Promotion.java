package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Promotion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Please provide Promotion Code!")
	private String promotionCode;
	
	@NotEmpty(message = "Please provide Discount!")
	@Length(min=0 , max=100)
	private int discount;
	
	@OneToMany(mappedBy = "promotionId")
	private List<PromotionDetail> promotionDetailList = new ArrayList<>();
	
	public Promotion() {
		super();
	}
	
	public Promotion(String promotionCode, int discount) {
		super();
		this.promotionCode = promotionCode;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	
	
	
	

}
