package com.rse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author SwapnilPremchandBirk
 *
 */
@Entity(name="RseTransactionDetails")
@Table(name = "RSE_TXN_DETAILS")
public class RseTransactionDetails implements Comparable<RseTransactionDetails>{

	@Id
	@Column(name = "RSE_TXN_DETAIL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	

	@Column(name = "ACCT_NUMBER" )
	private String acctNumber;
	
	@Column(name = "TXN_ID")
	private String txnId;
	
	@Column(name = "CARD_EXPIRY_DATE")
	private String cardExpiryDate;
	
	@Column(name = "ACCT_TYPE")
	private String acctType;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "CARD_HOLDER_NAME")
	private String cardholderName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column(name = "PLATFORM")
	private String platform;
	
	@Column(name = "DEVICE_MODEL")
	private String deviceModel;
	
	@Column(name = "OS_NAME")
	private String osName;
	
	@Column(name = "OS_VERSION")
	private String osVersion;
	
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	
	@Column(name = "TIME_ZONE")
	private String timeZone;
	
	@Column(name = "BROWSER_IP")
	private String browserIP;
	
	@Column(name = "BROWSER_LANGUAGE")
	private String browserLanguage;
	
	@Column(name = "BROWSER_ACCEPT_HEADER")
	private String browserAcceptHeader;
	
	@Column(name = "PURCHASE_AMOUNT")
	private String purchaseAmount;
	
	@Column(name = "PURCHASE_CURRENCY")
	private String purchaseCurrency;
	
	@Column(name = "TXN_DATE_TIME")
	private String txndateTime;
	
	@Column(name = "MERCHANT_NAME")
	private String merchantName;
	
	@Column(name = "MERCHANT_MCC")
	private String merchantMCC;

	@Column(name = "MERCHANT_CNTRY_CODE")
	private String merchantCntryCode;
	
	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;
	
	@Column(name = "RISK_SCORE")
	private String riskScore;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	
	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getBrowserIP() {
		return browserIP;
	}

	public void setBrowserIP(String browserIP) {
		this.browserIP = browserIP;
	}

	public String getBrowserLanguage() {
		return browserLanguage;
	}

	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = browserLanguage;
	}

	public String getBrowserAcceptHeader() {
		return browserAcceptHeader;
	}

	public void setBrowserAcceptHeader(String browserAcceptHeader) {
		this.browserAcceptHeader = browserAcceptHeader;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPurchaseCurrency() {
		return purchaseCurrency;
	}

	public void setPurchaseCurrency(String purchaseCurrency) {
		this.purchaseCurrency = purchaseCurrency;
	}

	public String getTxndateTime() {
		return txndateTime;
	}

	public void setTxndateTime(String txndateTime) {
		this.txndateTime = txndateTime;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantMCC() {
		return merchantMCC;
	}

	public void setMerchantMCC(String merchantMCC) {
		this.merchantMCC = merchantMCC;
	}

	public String getMerchantCntryCode() {
		return merchantCntryCode;
	}

	public void setMerchantCntryCode(String merchantCntryCode) {
		this.merchantCntryCode = merchantCntryCode;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(String riskScore) {
		this.riskScore = riskScore;
	}

	
	@Override
	 public int compareTo(RseTransactionDetails rse) {
	 
	  if (rse.getId() > this.getId()) {
	   return 1;
	  } else if (rse.getId() < this.getId()) {
	   return -1;
	  }
	  return 0;
	 }
	
	
	@Override
	public String toString() {
		return "RseTransactionDetails [Id=" + Id + ", acctNumber=" + acctNumber + ", txnId=" + txnId
				+ ", cardExpiryDate=" + cardExpiryDate + ", acctType=" + acctType + ", brand=" + brand
				+ ", cardholderName=" + cardholderName + ", email=" + email + ", ipAddress=" + ipAddress + ", platform="
				+ platform + ", deviceModel=" + deviceModel + ", osName=" + osName + ", osVersion=" + osVersion
				+ ", deviceName=" + deviceName + ", timeZone=" + timeZone + ", browserIP=" + browserIP
				+ ", browserLanguage=" + browserLanguage + ", browserAcceptHeader=" + browserAcceptHeader
				+ ", purchaseAmount=" + purchaseAmount + ", purchaseCurrency=" + purchaseCurrency + ", txndateTime="
				+ txndateTime + ", merchantName=" + merchantName + ", merchantMCC=" + merchantMCC
				+ ", merchantCntryCode=" + merchantCntryCode + ", shippingAddress=" + shippingAddress + ", riskScore="
				+ riskScore + "]";
	}

}
