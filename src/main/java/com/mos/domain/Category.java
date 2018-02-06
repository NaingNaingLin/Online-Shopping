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
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    
    @NotEmpty(message = "Please provide Category Code!")
    private String categoryCode;
    
    @NotEmpty(message = "Please provide Category Name!")
    private String name;
    
    @NotEmpty(message = "Please provide Description!")
    private String description;
    
    @OneToMany(mappedBy = "categoryId")
    private List<Product> productList = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryCode, String name, String description) {
        this.categoryCode = categoryCode;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return categoryId;
    }

    public void setId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	
}

