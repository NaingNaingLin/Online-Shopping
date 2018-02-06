package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Purchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseId;
	

	@ManyToOne
	private Customer customerId;
	
	@OneToMany(mappedBy="purchaseId")
	private List<PurchaseDetail> purchaseDetailCollection = new ArrayList<>();
	
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<PurchaseDetail> getPurchaseDetailCollection() {
		return purchaseDetailCollection;
	}

	public void setPurchaseDetailCollection(List<PurchaseDetail> purchaseDetailCollection) {
		this.purchaseDetailCollection = purchaseDetailCollection;
	}

	
	
	
}
