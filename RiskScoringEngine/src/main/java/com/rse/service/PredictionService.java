/**
 * 
 */
package com.rse.service;

import com.rse.model.RseTransactionDetails;

/**
 * @author SwapnilPremchandBirk
 *
 */
public interface PredictionService {

	public String getPrediction(RseTransactionDetails rseTransactionDetails);
	public RseTransactionDetails saveTransaction(RseTransactionDetails rseTransactionDetails) ;

}
