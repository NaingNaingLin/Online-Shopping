package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.mos.helperclasses.Address;

@Entity
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyId;
	
	@NotEmpty(message="Company Code cannot be Empty.")
	private String companyCode;
	
	@NotEmpty(message="Company Name cannot be Empty.")
	private String companyName;
	
	@NotEmpty(message="License No cannot be Empty.")
	private String licenseNo;
	
	@Email
	private String email;
	
	@Embedded
	private Address address;
	
	@NotEmpty(message="Phone Number cannot be Empty.")
	private String phoneNo;
	
	@OneToOne
	@JoinColumn(name="Account_Id")
	private Account accountId;
	
	@OneToMany(mappedBy="companyId")
	private List<Product> productList = new ArrayList<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
