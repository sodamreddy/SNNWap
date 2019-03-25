package com.usa.gov.ssn.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.gov.ssn.constants.ApplicationConstants;
import com.usa.gov.ssn.model.ApplicationModel;
import com.usa.gov.ssn.properties.ApplicationProperties;
import com.usa.gov.ssn.service.ApplicationService;



@Controller
public class AppRegController {
	Logger logger = LoggerFactory.getLogger(AppRegController.class);
	@Autowired(required=true)
	private ApplicationService applicationService;
	@Autowired(required=true)
	private ApplicationProperties properties;
	
	/**
	 * this method is used to load form page for registration
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/appReg", method = RequestMethod.GET)
	public String appRegForm(Model model) {
		logger.debug("AppController: appRegForm Started");
		ApplicationModel appModel = new ApplicationModel();
		// Add AppAccount to Model Scope
		model.addAttribute("appModel", appModel);
		logger.debug("AppController: appRegForm Ended");
		logger.info("AppController: Registration Form loaded Sucessfully");
		return "appReg";
	}

	/**
	 * this method is use to process the Account Registration Form
	 * 
	 * @param accModel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/accReg", method = RequestMethod.POST)
	public String appAccountRegForm(@ModelAttribute("appModel") ApplicationModel appModel, Model model) {
		logger.debug("ApplicationController: accRegFor() POST method started");
		// get properties
		Map<String, String> appProps = properties.getProperties();
		try {
			// call registerApplicant method
			boolean isSaved = applicationService.registerApplicant(appModel);
			if (isSaved) {
				model.addAttribute(ApplicationConstants.SUCCESS, appProps.get(ApplicationConstants.REG_SUCCESS));
			} else {
				model.addAttribute(ApplicationConstants.FAILED, appProps.get(ApplicationConstants.FAILED));
			} // IF

		} catch (Exception e) {
			logger.warn("Registration failed:" + e.getMessage());
		}
		return "appReg";
	}
}
