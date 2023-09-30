package com.rse.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rse.dao.TransactionDetailsDao;
import com.rse.dao.TxnPercentageDao;
import com.rse.dao.WeightageDao;
import com.rse.model.RseTransactionDetails;
import com.rse.model.RseTxnParameterCount;
import com.rse.model.RseTxnPercentage;
import com.rse.model.RseWeightageMaster;
import com.rse.service.PredictionService;
import com.rse.utility.Utility;

@Service
public class PredictionServiceImpl implements PredictionService {

	@Autowired
	TransactionDetailsDao transactionDetailsDao;

	@Autowired
	WeightageDao weightageDao;

	@Autowired
	Utility utility;

	@Autowired
	TxnPercentageDao txnPercentageDao;

	public List<RseTransactionDetails> txnDetailsList = new ArrayList<>();

	@Override
	public String getPrediction(RseTransactionDetails rseTransactionDetails) {
		RseTxnPercentage parameterPercentage = new RseTxnPercentage();
		RseTxnParameterCount parameterCount = getDataset(rseTransactionDetails);

		System.out.println("parameterCount : " + parameterCount.toString());

		int totalTxnCount = parameterCount.getTotalRecordCount();
		List<RseWeightageMaster> weights = weightageDao.findAll();
		int grandTotal = 0;
		int grandScore = 0;
		String riskScore;
		int average = 0;
		int per = 100;

		for (RseWeightageMaster master : weights) {
			int weight, fieldCount = 0;
			String parameterPercent;

			switch (master.getFieldName()) {
			case "acctNumber":
				weight = master.getWeight();
				fieldCount = parameterCount.getAcctNumber();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setAcctNumber(parameterPercent);
				break;
			case "txnId":
				weight = master.getWeight();
				fieldCount = parameterCount.getTxnId();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setTxnId(parameterPercent);
				break;
			case "cardExpiryDate":
				weight = master.getWeight();
				fieldCount = parameterCount.getCardExpiryDate();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setCardExpiryDate(parameterPercent);
				break;
			case "acctType":
				weight = master.getWeight();
				fieldCount = parameterCount.getAcctType();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setAcctType(parameterPercent);
				break;
			case "brand":
				weight = master.getWeight();
				fieldCount = parameterCount.getBrand();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setBrand(parameterPercent);
				break;
			case "cardholderName":
				weight = master.getWeight();
				fieldCount = parameterCount.getCardHolderName();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setCardholderName(parameterPercent);
				break;
			case "email":
				weight = master.getWeight();
				fieldCount = parameterCount.getEmail();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setEmail(parameterPercent);
				break;
			case "ipAddress":
				weight = master.getWeight();
				fieldCount = parameterCount.getIpAddress();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setIpAddress(parameterPercent);
				break;
			case "platform":
				weight = master.getWeight();
				fieldCount = parameterCount.getPlatform();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setPlatform(parameterPercent);
				break;
			case "deviceModel":
				weight = master.getWeight();
				fieldCount = parameterCount.getDeviceModel();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setDeviceModel(parameterPercent);
				break;
			case "osName":
				weight = master.getWeight();
				fieldCount = parameterCount.getOsName();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setOsName(parameterPercent);
				break;
			case "osVersion":
				weight = master.getWeight();
				fieldCount = parameterCount.getOsVersion();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setOsVersion(parameterPercent);
				break;
			case "deviceName":
				weight = master.getWeight();
				fieldCount = parameterCount.getDeviceName();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setDeviceName(parameterPercent);
				break;
			case "timeZone":
				weight = master.getWeight();
				fieldCount = parameterCount.getTimeZone();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setTimeZone(parameterPercent);
				break;
			case "browserIP":
				weight = master.getWeight();
				fieldCount = parameterCount.getBrowserIP();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setBrowserIP(parameterPercent);
				break;
			case "browserLanguage":
				weight = master.getWeight();
				fieldCount = parameterCount.getBrowserLanguage();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setBrowserLanguage(parameterPercent);
				break;
			case "browserAcceptHeader":
				weight = master.getWeight();
				fieldCount = parameterCount.getBrowserAcceptHeader();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setBrowserAcceptHeader(parameterPercent);
				break;
			case "purchaseAmount":
				System.out.println(parameterCount.getPurchaseAmount());
				average = parameterCount.getPurchaseAmount();
				int amount = (int)Double.parseDouble(rseTransactionDetails.getPurchaseAmount());
				if (amount >= average * 2) {
					weight = 5;
				} else if (amount >= average && amount < average * 2) {
					weight = 4;
				} else if (amount < average) {
					weight = 2;
				} else {
					weight = master.getWeight();
				}
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setPurchaseAmount(parameterPercent);
				break;
			case "purchaseCurrency":
				weight = master.getWeight();
				fieldCount = parameterCount.getPurchaseCurrency();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setPurchaseCurrency(parameterPercent);
				break;
			case "txndateTime":
				weight = master.getWeight();
				fieldCount = parameterCount.getTxnDateTime();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setTxndateTime(parameterPercent);
				break;
			case "merchantName":
				weight = master.getWeight();
				fieldCount = parameterCount.getMerchantName();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setMerchantName(parameterPercent);
				break;
			case "merchantMCC":
				weight = master.getWeight();
				fieldCount = parameterCount.getMerchantMCC();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setMerchantMCC(parameterPercent);
				break;
			case "merchantCntryCode":
				weight = master.getWeight();
				fieldCount = parameterCount.getMerchantCntryCode();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setMerchantCntryCode(parameterPercent);
				break;
			case "shippingAddress":
				weight = master.getWeight();
				fieldCount = parameterCount.getShippingAddress();
				parameterPercent = getPercentage(totalTxnCount, fieldCount, weight);
				grandScore += Integer.valueOf(parameterPercent);
				grandTotal += 100;
				parameterPercent = String.valueOf(per-Integer.valueOf(parameterPercent));
				parameterPercentage.setShippingAddress(parameterPercent);
				break;
			}
		}
		int parameterRisk = 0, businessRisk = 0;

		int parameterFactor = 100 - Math.round(((float) grandScore / grandTotal) * 100);
		parameterRisk = (int) ((float) (parameterFactor * 75) / 100);

		int riskFactors = utility.businessRiskEvaluation(txnDetailsList, rseTransactionDetails);
		businessRisk = (int) ((float) (riskFactors * 25) / 100);

		int riskPercentage = parameterRisk + businessRisk;
		riskScore = String.format("%d", riskPercentage);
		rseTransactionDetails.setRiskScore(riskScore);

		saveTransaction(rseTransactionDetails);
		parameterPercentage.setRseTxnDetailsId(String.valueOf(rseTransactionDetails.getId()));
		txnPercentageDao.save(parameterPercentage);

		return "This transaction has "+riskScore + "% risk";
	}

	private String getPercentage(int totalTxnCount, int fieldCount, int weight) {
		return String.format("%d", Math.round(((float) (fieldCount * weight) / (totalTxnCount * weight)) * 100));
	}

	private RseTxnParameterCount getDataset(RseTransactionDetails rseTransactionDetails) {

		String accNumber = rseTransactionDetails.getAcctNumber();
		txnDetailsList = transactionDetailsDao.findByAccNo(accNumber);
		RseTxnParameterCount parameterCount = new RseTxnParameterCount();
		txnDetailsList.forEach(txnDetails -> utility.getMachedCount(txnDetails, parameterCount, rseTransactionDetails));
		
		parameterCount.setPurchaseAmount(utility.getAverage(txnDetailsList));

		return parameterCount;
	}

	public RseTransactionDetails saveTransaction(RseTransactionDetails rseTransactionDetails) {
		transactionDetailsDao.save(rseTransactionDetails);
		return transactionDetailsDao.save(rseTransactionDetails);
	}

}
