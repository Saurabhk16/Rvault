package com.rse.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rse.model.RseTransactionDetails;


public interface TransactionDetailsDao extends JpaRepository<RseTransactionDetails, Long> {
	
	@Query(value = "FROM RseTransactionDetails e WHERE e.acctNumber = :acctNumber")
	public List<RseTransactionDetails> findByAccNo(@Param("acctNumber") String acctNumber);
	
	@Query(value = "FROM RseTransactionDetails e WHERE e.acctNumber = :acctNumber order by Id DESC")
	public List<RseTransactionDetails> findLatestTxn(@Param("acctNumber") String acctNumber);
	
}
