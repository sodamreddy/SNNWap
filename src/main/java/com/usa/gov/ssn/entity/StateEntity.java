package com.usa.gov.ssn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="states")
@Entity
public class StateEntity {
	@Column(name="sno")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sno;
	@Column(name="state_code")
	private String stateCode;
	@Column(name="state_name")
	private String stateName;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}
