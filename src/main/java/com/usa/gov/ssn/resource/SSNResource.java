package com.usa.gov.ssn.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usa.gov.ssn.exception.SSNNotFoundException;
import com.usa.gov.ssn.model.SSNProfile;
import com.usa.gov.ssn.service.ApplicationService;

@RestController
public class SSNResource {
	Logger logger= LoggerFactory.getLogger(SSNResource.class);
	@Autowired
	ApplicationService service;
	public SSNResource() {
		System.out.println("ssnresource constructor");
	}
	
	public ResponseEntity<Object> validateSSN(@PathVariable long ssn){
		logger.debug("SSNResource : validateSSN() started");
		SSNProfile profile= service.validateSSN(ssn);
		if(profile!=null) {
			logger.debug("validateSSN() method execution is ended");
			logger.debug("SSN validation is Completed");
			return ResponseEntity.ok(profile);
		}
		logger.debug("validateSSN() method execution is ended");
		logger.debug("SSN validation is faild");
		throw new SSNNotFoundException("Invalid SSN");
		
	}
	
}
