package com.finanace.shreeji.bo;

public class Config {
	private String agentNames;
	private String financerNames;

	public Config() {
		super();
	}

	public Config(String emails, String financernames) {
		super();
		this.agentNames = emails;
		this.financerNames = financernames;
	}

	public String getAgentNames() {
		return agentNames;
	}

	public void setAgentNames(String agentNames) {
		this.agentNames = agentNames;
	}

	public String getFinancerNames() {
		return financerNames;
	}

	public void setFinancerNames(String financerNames) {
		this.financerNames = financerNames;
	}

	@Override
	public String toString() {
		return "Config [agentNames=" + agentNames + ", financerNames=" + financerNames + "]";
	}
}
