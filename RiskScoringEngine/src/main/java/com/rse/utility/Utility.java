package com.rse.utility;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rse.model.RseTransactionDetails;
import com.rse.model.RseTxnParameterCount;
import com.rse.model.RseTxnPercentage;
import com.rse.model.RseWeightageMaster;

@Component
public class Utility {



	public RseTxnParameterCount getMachedCount(RseTransactionDetails txnDetails, RseTxnParameterCount parameterCount, RseTransactionDetails recTxnDetails){
		
		parameterCount.setTotalRecordCount(parameterCount.getTotalRecordCount()+1);
		
		if(txnDetails.getAcctNumber() != null  && recTxnDetails.getAcctNumber() != null  
				&& txnDetails.getAcctNumber().equals(recTxnDetails.getAcctNumber()))
			parameterCount.setAcctNumber(parameterCount.getAcctNumber()+1);
		
		if(txnDetails.getAcctType() != null  && recTxnDetails.getAcctType() != null  
				&& txnDetails.getAcctType().equals(recTxnDetails.getAcctType())) 
			parameterCount.setAcctType(parameterCount.getAcctType()+1);
		
		if(txnDetails.getBrand() != null  && recTxnDetails.getBrand() != null  
				&& txnDetails.getBrand().equals(recTxnDetails.getBrand())) 
			parameterCount.setBrand(parameterCount.getBrand()+1);
		
		if(txnDetails.getBrowserAcceptHeader() != null  && recTxnDetails.getBrowserAcceptHeader() != null  
				&& txnDetails.getBrowserAcceptHeader().equals(recTxnDetails.getBrowserAcceptHeader()))
			parameterCount.setBrowserAcceptHeader(parameterCount.getBrowserAcceptHeader()+1);
		
		if(txnDetails.getBrowserIP() != null  && recTxnDetails.getBrowserIP() != null  
				&& txnDetails.getBrowserIP().equals(recTxnDetails.getBrowserIP())) 
			parameterCount.setBrowserIP(parameterCount.getBrowserIP()+1);
		
		if(txnDetails.getBrowserLanguage() != null  && recTxnDetails.getBrowserLanguage() != null  
				&& txnDetails.getBrowserLanguage().equals(recTxnDetails.getBrowserLanguage())) 
			parameterCount.setBrowserLanguage(parameterCount.getBrowserLanguage()+1);
		
		if(txnDetails.getCardExpiryDate() != null  && recTxnDetails.getCardExpiryDate() != null 
				&& txnDetails.getCardExpiryDate().equals(recTxnDetails.getCardExpiryDate()))
			parameterCount.setCardExpiryDate(parameterCount.getCardExpiryDate()+1);
		
		if(txnDetails.getCardholderName() != null  && recTxnDetails.getCardholderName() != null  
				&& txnDetails.getCardholderName().equals(recTxnDetails.getCardholderName()))
			parameterCount.setCardHolderName(parameterCount.getCardHolderName()+1);
		
		if(txnDetails.getDeviceModel() != null  && recTxnDetails.getDeviceModel() != null  
				&& txnDetails.getDeviceModel().equals(recTxnDetails.getDeviceModel()))
			parameterCount.setDeviceModel(parameterCount.getDeviceModel()+1);
		
		if(txnDetails.getDeviceName() != null  && recTxnDetails.getDeviceName() != null  
				&& txnDetails.getDeviceName().equals(recTxnDetails.getDeviceName()))
			parameterCount.setDeviceName(parameterCount.getDeviceName()+1);
		
		if(txnDetails.getEmail() != null  && recTxnDetails.getEmail() != null  
				&& txnDetails.getEmail().equals(recTxnDetails.getEmail()))
			parameterCount.setEmail(parameterCount.getEmail()+1);
		
		if(txnDetails.getIpAddress() != null && recTxnDetails.getIpAddress() != null 
				&& txnDetails.getIpAddress().equals(recTxnDetails.getIpAddress()))
			parameterCount.setIpAddress(parameterCount.getIpAddress()+1);
		
		if(txnDetails.getMerchantCntryCode() != null  && recTxnDetails.getMerchantCntryCode() != null  
				&& txnDetails.getMerchantCntryCode().equals(recTxnDetails.getMerchantCntryCode()))
			parameterCount.setMerchantCntryCode(parameterCount.getMerchantCntryCode()+1);
		
		if(txnDetails.getMerchantMCC() != null  && recTxnDetails.getMerchantMCC() != null 
				&& txnDetails.getMerchantMCC().equals(recTxnDetails.getMerchantMCC()))
			parameterCount.setMerchantMCC(parameterCount.getMerchantMCC()+1);
		
		if(txnDetails.getMerchantName() != null  && recTxnDetails.getMerchantName() != null  
				&& txnDetails.getMerchantName().equals(recTxnDetails.getMerchantName()))
			parameterCount.setMerchantName(parameterCount.getMerchantName()+1);
		
		if(txnDetails.getOsName() != null  && recTxnDetails.getOsName() != null  
				&& txnDetails.getOsName().equals(recTxnDetails.getOsName()))
			parameterCount.setOsName(parameterCount.getOsName()+1);
		
		if(txnDetails.getOsVersion() != null  && recTxnDetails.getOsVersion() != null 
				&& txnDetails.getOsVersion().equals(recTxnDetails.getOsVersion()))
			parameterCount.setOsVersion(parameterCount.getOsVersion()+1);
		
		if(txnDetails.getPlatform() != null && recTxnDetails.getPlatform() != null 
				&& txnDetails.getPlatform().equals(recTxnDetails.getPlatform()))
			parameterCount.setPlatform(parameterCount.getPlatform()+1);
		
		/*if(txnDetails.getPurchaseAmount() != null  && recTxnDetails.getPurchaseAmount() != null  
				&& txnDetails.getPurchaseAmount() .equals(recTxnDetails.getPurchaseAmount()))
			parameterCount.setPurchaseAmount(parameterCount.getPurchaseAmount()+1);*/
		
		if(txnDetails.getPurchaseCurrency() != null  && recTxnDetails.getPurchaseCurrency() != null 
				&& txnDetails.getPurchaseCurrency().equals(recTxnDetails.getPurchaseCurrency()))
			parameterCount.setPurchaseCurrency(parameterCount.getPurchaseCurrency()+1);
		
		if(txnDetails.getShippingAddress() != null  && recTxnDetails.getShippingAddress() != null  
				&& txnDetails.getShippingAddress().equals(recTxnDetails.getShippingAddress()))
			parameterCount.setShippingAddress(parameterCount.getShippingAddress()+1);
		
		if(txnDetails.getTimeZone() != null && recTxnDetails.getTimeZone() != null  
				&& txnDetails.getTimeZone().equals(recTxnDetails.getTimeZone()))
			parameterCount.setTimeZone(parameterCount.getTimeZone()+1);
		
		if(txnDetails.getTxndateTime() != null  && recTxnDetails.getTxndateTime() != null 
				&& txnDetails.getTxndateTime().equals(recTxnDetails.getTxndateTime()))
			parameterCount.setTxnDateTime(parameterCount.getTxnDateTime()+1);
		
		return parameterCount ;
	}
	

	public int businessRiskEvaluation(List<RseTransactionDetails> txnDetailsList, RseTransactionDetails rseTransactionDetails) {

		Collections.sort(txnDetailsList);  
		List<RseTransactionDetails> latestTxn = txnDetailsList.stream().limit(5).collect(Collectors.toList());
		int riskFactors =0 ;
		riskFactors +=riskFactorOne(latestTxn,riskFactors);
		riskFactors += riskFactorTwo(latestTxn,rseTransactionDetails,riskFactors);
		
		//riskFactorThree();
		//riskFactorFour();
		//riskFactorFive();
		
		return riskFactors;
	}
	
	private int riskFactorOne(List<RseTransactionDetails> latestTxn , int riskFactors) {

		if(latestTxn.size()<5)
			riskFactors = 50;
	
		return riskFactors;
	}

	private int riskFactorTwo(List<RseTransactionDetails> latestTxn,RseTransactionDetails rseTransactionDetails, int riskFactors) {

		int average = getAverage(latestTxn);
		if (average < (int)Double.parseDouble(rseTransactionDetails.getPurchaseAmount()))
			riskFactors = 50;
		
		return riskFactors;
	}

	private int riskFactorThree() {

		return 0;
	}

	private int riskFactorFour() {

		return 0;
	}

	private int riskFactorFive() {

		return 0;
	}

	public int getAverage(List<RseTransactionDetails> txnDetailsList) {
		
		List<String> purchaseAmount = txnDetailsList.stream().map(RseTransactionDetails::getPurchaseAmount).collect(Collectors.toList());
		List<Float> floatPurchaseAmount = purchaseAmount.stream().map(Float::valueOf).collect(Collectors.toList());
		return (int)floatPurchaseAmount.stream().mapToDouble(d -> d).average().orElse(0.0);
	}
}
