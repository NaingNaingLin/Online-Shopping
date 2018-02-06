package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.mos.helperclasses.Address;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private int customerCode;
	@NotEmpty(message="First Name cannot be Empty.")
	private String firstName;
	@NotEmpty(message="Last Name cannot be Empty.")
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotEmpty(message="NRC cannot be Empty.")
	private String nrc;
	@Embedded
	private Address address;
	@NotEmpty(message="Phone Number cannot be Empty.")
	private String phoneNo;
	
	@OneToOne
	@JoinColumn(name="Account_Id")
	private Account accountId;
	
	@OneToMany(mappedBy="customerId")
	private Collection<Purchase> purchaseCollection;
	
	@OneToMany(mappedBy="customerId")
	private List<FavouriteProduct> favouriteProductCollection = new ArrayList<>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getCustomerCode() {
		return customerCode;
	}


	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getNrc() {
		return nrc;
	}


	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Collection<Purchase> getPurchaseCollection() {
		return purchaseCollection;
	}


	public void setPurchaseCollection(Collection<Purchase> purchaseCollection) {
		this.purchaseCollection = purchaseCollection;
	}


	public List<FavouriteProduct> getFavouriteProductCollection() {
		return favouriteProductCollection;
	}


	public void setFavouriteProductCollection(List<FavouriteProduct> favouriteProductCollection) {
		this.favouriteProductCollection = favouriteProductCollection;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Account getAccountId() {
		return accountId;
	}


	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	
	
	
}
