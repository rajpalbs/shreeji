package com.finanace.shreeji.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.bo.Config;
import com.finanace.shreeji.repository.ConfigRepository;

@Service("configManagementService")
public class ConfigManagementService {

	@Autowired
	private ConfigRepository configRepository;

	public Config deleteAndRecreateConfig(Config latestConfig) {
		configRepository.deleteConfig();
		configRepository.saveConfig(latestConfig);
		return configRepository.getConfig().orElse(new Config());
	}

	public Config getConfig() {
		return configRepository.getConfig().orElse(new Config());
	}

	public List<String> getAgentNames(){
		return new ArrayList<String>(Arrays.asList(configRepository.getAgents().split(",")));
	}
	
	public List<String> getFinancerBankNames() {
		return new ArrayList<String>(Arrays.asList(configRepository.getFinanceBank().split(",")));
	}
	
}
