package com.finanace.shreeji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.bo.Config;
import com.finanace.shreeji.service.ConfigManagementService;

@Controller
public class ConfigurationController {

	@Autowired
	private ConfigManagementService configManagementService;
	
	@RequestMapping(value = "/config" , method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		Config config = configManagementService.getConfig();
		modelAndView.addObject("config",config);
		modelAndView.setViewName("/config");
		return modelAndView;
	}
	
	@RequestMapping(value = "/config" , method = RequestMethod.POST)
	public ModelAndView saveOrUpdateConfig(Config config) {
		ModelAndView modelAndView = new ModelAndView();
		Config updatedConfig = configManagementService.deleteAndRecreateConfig(config);
		modelAndView.addObject("config",updatedConfig);
		modelAndView.addObject("msg","Configuration Updated Successfully !!!");
		
		modelAndView.setViewName("/config");
		return modelAndView;
	}
}
