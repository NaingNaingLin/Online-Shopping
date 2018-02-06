package com.mos.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@JoinColumn(name="Customer_Id", referencedColumnName="customerId")
	@ManyToOne
	private Customer customerId;
	
	@OneToMany(mappedBy="purchaseId")
	private Collection<PurchaseDetail> purchaseDetailCollection;
	
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

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

	public Collection<PurchaseDetail> getPurchaseDetailCollection() {
		return purchaseDetailCollection;
	}

	public void setPurchaseDetailCollection(Collection<PurchaseDetail> purchaseDetailCollection) {
		this.purchaseDetailCollection = purchaseDetailCollection;
	}
	
	
}
