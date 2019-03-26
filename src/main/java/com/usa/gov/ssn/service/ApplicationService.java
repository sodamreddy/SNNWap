package com.usa.gov.ssn.service;

import java.util.Map;

import com.usa.gov.ssn.model.ApplicationModel;
import com.usa.gov.ssn.model.SSNProfile;

public interface ApplicationService {

	public boolean registerApplicant(ApplicationModel appModel);
	public SSNProfile validateSSN(long ssn);
	public Map<String,String> getAllStates();

}
