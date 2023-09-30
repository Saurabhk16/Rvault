package com.rse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RSE_WEIGHTAGE_MASTER")
public class RseWeightageMaster {
	@Id
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "FIELD_NAME" )
	private String fieldName;
	
	@Column(name = "WEIGHT")
	private int weight;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	
}
