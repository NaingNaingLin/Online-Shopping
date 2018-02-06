package com.mos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    
    @NotEmpty(message = "Please provide Brand Code!")
    private String brandCode;
    
    @NotEmpty(message = "Please provide Brand Name!")
    private String name;
    
    @NotEmpty(message = "Please provide Made in Country!")
    private String country;
    
    @NotEmpty(message = "Please provide Description!")
    private String Description;
    
    @OneToMany(mappedBy = "brandId")
    private List<Product> productList = new ArrayList<>();

    public Brand() {
    }

    public Brand(String brandCode, String name, String country, String Description) {
        this.brandCode = brandCode;
        this.name = name;
        this.country = country;
        this.Description = Description;
    }

    public int getId() {
        return brandId;
    }

    public void setId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

	
}

