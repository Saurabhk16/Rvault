package com.rse.model;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="Email")
@Cacheable(false)
@Table(name = "emaildetails")
public class EmailDetails implements Comparable<EmailDetails>{


	@Id
	@Column(name = "id")
	private int Id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FLAG")
	private String flag;

	@Column(name = "REQ_MID")
	private String requestedMid;

	@Column(name = "DOC_TYPE")
	private String documentType;

	@Column(name = "DATE")
	private Timestamp date;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRequestedMid() {
		return requestedMid;
	}

	public void setRequestedMid(String requestedMid) {
		this.requestedMid = requestedMid;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int compareTo(EmailDetails o) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
