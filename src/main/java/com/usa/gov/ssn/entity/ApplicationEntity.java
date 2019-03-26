package com.usa.gov.ssn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User_Applications")
public class ApplicationEntity {
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_name")
	private String lastName;
	
	@Column(name="Date_Of_Birth")
	private String dateOfBirth;
	
	@Column(name="phone_no")
	private String phoneNo;
	
//	@Id
//	@SequenceGenerator(name = "gen1", sequenceName="ssn_sequence")
//	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
//	@Column(name="SSN")
//	private long ssn;
	@Id
	@GeneratedValue(generator="gen1",strategy=GenerationType.AUTO)
	@Column(name="SSN")
	private long ssn;
	
	@Column(name="Email_Id")
	private String emailId;
	
	@Column(name="Gender")
	private String gender;
	@Column(name="State")
	private String state;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
