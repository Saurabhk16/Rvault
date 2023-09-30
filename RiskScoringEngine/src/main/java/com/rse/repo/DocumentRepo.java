package com.rse.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rse.model.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{

	Optional<Document> findByName(String fileName);
	@Query(value = "FROM Document e WHERE e.merchant = :merchant and e.dname = :dname")
	public Document findBymerchant(@Param("merchant") String merchant,@Param("dname") String dname);




}
