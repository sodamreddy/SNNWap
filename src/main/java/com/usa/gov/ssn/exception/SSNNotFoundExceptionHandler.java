package com.usa.gov.ssn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class SSNNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

	public SSNNotFoundExceptionHandler() {
		System.out.println("SSNNotFoundExceptionHandler.SSNNotFoundExceptionHandler()");
	}
	public ResponseEntity<InvalidSSN> exceptionHandler(SSNNotFoundException ex,WebRequest request){
		InvalidSSN exception = new InvalidSSN();
		exception.setStatusCode(400);
		exception.setErrorDesc("Invalid SSN");
		return new ResponseEntity<InvalidSSN>(exception,HttpStatus.BAD_REQUEST);
	}

}
