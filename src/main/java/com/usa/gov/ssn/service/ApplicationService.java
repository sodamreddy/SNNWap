package com.usa.gov.ssn.service;

import org.springframework.stereotype.Service;

import com.usa.gov.ssn.model.ApplicationModel;

public interface ApplicationService {

	boolean registerApplicant(ApplicationModel appModel);

}
