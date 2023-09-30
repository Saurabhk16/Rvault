package com.rse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rse.model.RseWeightageMaster;

@Repository
public interface WeightageDao extends JpaRepository<RseWeightageMaster, Long>{

	
}
