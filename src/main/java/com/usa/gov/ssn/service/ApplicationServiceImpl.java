package com.usa.gov.ssn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gov.ssn.entity.ApplicationEntity;
import com.usa.gov.ssn.entity.StateEntity;
import com.usa.gov.ssn.model.ApplicationModel;
import com.usa.gov.ssn.model.SSNProfile;
import com.usa.gov.ssn.repository.ApplicationRegRepository;
import com.usa.gov.ssn.repository.StatesRepository;
@Service
public class ApplicationServiceImpl implements ApplicationService {
	Logger logger= LoggerFactory.getLogger(ApplicationServiceImpl.class);
	@Autowired(required=true)
	ApplicationRegRepository applicationRegRepository;
	@Autowired(required=true)
	StatesRepository statesRepository;
	@Override
	public boolean registerApplicant(ApplicationModel appModel) {
		logger.debug("ApplicationServiceImpl: registerApplicant() started");
		ApplicationEntity entity= new ApplicationEntity();
		//copy model obj props to entity obj
		BeanUtils.copyProperties(appModel, entity);
		try {
			entity=applicationRegRepository.save(entity);
		}catch(Exception e) {
		logger.debug("ApplicationServiceImpl: registerApplicant() started failed "+e.getMessage());
			return false;
		}
		logger.debug("ApplicationServiceImpl: registerApplicant() started ended");
		return true;
	}
	@Override
	public SSNProfile validateSSN(long ssn) {
		SSNProfile profile= new SSNProfile();
		ApplicationEntity entity;
		Optional<ApplicationEntity>optionEntity= applicationRegRepository.findById(ssn);
		if(optionEntity.isPresent()) {
			entity=optionEntity.get();
			if(entity!=null) {
				BeanUtils.copyProperties(entity, profile);
				logger.debug("ApplicationServiceImpl: validateSSN() executd ");
				logger.info("SSN retrival completed");
				return profile;
			}
		}
		logger.debug("ApplicationServiceImpl: validateSSN() executd ");
		logger.info("SSN retrival failed");
		return null;
	}
	@Override
	public Map<String, String> getAllStates() {
		List<StateEntity> listStates=statesRepository.findAll();
		Map<String , String> statesMap= new HashMap<String, String>();
		for (StateEntity stateEntity : listStates) {
			statesMap.put(stateEntity.getStateCode(), stateEntity.getStateName());
		}
		return statesMap;
	}

}
