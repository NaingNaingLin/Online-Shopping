package com.mos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mos.domain.FieldMaster;

@Repository
public interface FieldMasterRepository extends JpaRepository<FieldMaster, Integer> {

	@Query("Select f from FieldMaster f order by f.fieldName")
	List<FieldMaster> findAll();
	
	@Query("Select f from FieldMaster f where f.fieldName = :fieldName")
	FieldMaster findByFieldName(@Param("fieldName") String fieldName);
	
	@Query("Select f from FieldMaster f where f.fieldCode = :fieldCode")
	FieldMaster findByFieldCode(@Param("fieldCode") String fieldCode);
}
