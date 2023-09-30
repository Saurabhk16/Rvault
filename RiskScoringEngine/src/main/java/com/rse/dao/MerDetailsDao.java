package com.rse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rse.model.Merchant;


public interface MerDetailsDao extends JpaRepository<Merchant, Long> {
	
	@Query(value = "FROM Merchant e WHERE e.email = :email")
	public Merchant findByEmail(@Param("email") String email);
}
