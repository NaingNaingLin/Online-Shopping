package com.mos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mos.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}