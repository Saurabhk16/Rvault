package com.rse.model;

import java.util.Date;
import java.util.List;

public class DocResponce {

	private boolean status;
	private String merchantEmail;
	private Date timestamp= new Date();
	private List<DocumentSub> document;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public List<DocumentSub> getDocument() {
		return document;
	}
	public void setDocument(List<DocumentSub> document) {
		this.document = document;
	}

}
