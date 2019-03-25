package com.usa.gov.ssn.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gov.ssn.entity.ApplicationEntity;
import com.usa.gov.ssn.model.ApplicationModel;
import com.usa.gov.ssn.repository.ApplicationRegRepository;
@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired(required=true)
	ApplicationRegRepository repo;
	@Override
	public boolean registerApplicant(ApplicationModel appModel) {
		ApplicationEntity entity= new ApplicationEntity();
		//copy model obj props to entity obj
		BeanUtils.copyProperties(appModel, entity);
		try {
			entity=repo.save(entity);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
