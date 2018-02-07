package com.mos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mos.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
