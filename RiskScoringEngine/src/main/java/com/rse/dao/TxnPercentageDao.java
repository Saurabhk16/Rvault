package com.rse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rse.model.RseTxnPercentage;

@Repository
public interface TxnPercentageDao extends JpaRepository<RseTxnPercentage, Long>{

}
