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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PromotionDetail implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promotionDetailId;
	
	@NotEmpty(message="Please provide Description!")
	private String Description;
	
	@NotEmpty(message="Please provide form Date!")
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@NotEmpty(message="Please provide to Date!")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	

	@ManyToOne
	@JoinColumn(name="Promotion_Id")
	private Promotion promotionId;
	

	@ManyToOne
	@JoinColumn(name="Product_Id")
	private Product productId;
	
	public PromotionDetail() {
		super();
	}
	public PromotionDetail(String description, Date fromDate, Date toDate) {
		super();
		this.Description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public int getId() {
		return promotionDetailId;
	}
	public void setId(int promotionDetailId) {
		this.promotionDetailId = promotionDetailId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
}
