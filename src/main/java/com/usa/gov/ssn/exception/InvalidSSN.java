package com.usa.gov.ssn.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InvalidSSN {
 private Integer statusCode;
 private String errorDesc;
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
public String getErrorDesc() {
	return errorDesc;
}
public void setErrorDesc(String errorDesc) {
	this.errorDesc = errorDesc;
}
}
