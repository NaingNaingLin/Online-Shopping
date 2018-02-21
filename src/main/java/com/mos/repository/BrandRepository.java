package com.mos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mos.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

	@Query("Select b from Brand b where b.brandCode like '%:brandCode%'")
	List<Brand> findByBrandCode(@Param("brandCode") String brandCode);
	
	@Query("Select b from Brand b where b.country like '%:country%'")
	List<Brand> findByCountry(@Param("country") String country);
	
	@Query("Select b from Brand b where b.name like '%:brandName%'")
	List<Brand> findByBrandName(@Param("brandName") String brandName);
}
