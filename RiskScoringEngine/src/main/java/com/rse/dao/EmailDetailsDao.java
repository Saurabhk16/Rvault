package com.rse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rse.model.EmailDetails;
import com.rse.model.Merchant;


public interface EmailDetailsDao extends JpaRepository<EmailDetails, Long> {
	
	@Query(value = "FROM Email e WHERE e.requestedMid = :requestedMid")
	public EmailDetails findByUser(@Param("requestedMid") String requestedMid);
}
