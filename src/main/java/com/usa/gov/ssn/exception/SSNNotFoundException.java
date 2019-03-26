package com.usa.gov.ssn.exception;

public class SSNNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SSNNotFoundException() {
		System.out.println("SSNNotFoundException.SSNNotFoundException()");
	}
	public SSNNotFoundException(String message) {
		super(message);
	}
}
