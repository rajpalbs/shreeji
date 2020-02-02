package com.finanace.shreeji.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.bo.Config;

@Repository
public class ConfigRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void deleteConfig() {
		jdbcTemplate.update("DELETE FROM CONFIG");
	}

	public void saveConfig(Config config) {
		jdbcTemplate.update("INSERT INTO CONFIG VALUES(?,?)", config.getAgentNames(), config.getFinancerNames());
	}

	public Optional<Config> getConfig() {
		return jdbcTemplate.queryForObject("SELECT * FROM CONFIG",
				(rs, rowNum) -> Optional.of(new Config(rs.getString(1), rs.getString(2))));
	}
	
	public String getAgents() {
		return jdbcTemplate.queryForObject("SELECT AGENT_NAMES FROM CONFIG",
				(rs, rowNum) -> new String(rs.getString(1)));
	}

	public String getFinanceBank() {
		return jdbcTemplate.queryForObject("SELECT FINANCE_BANKS FROM CONFIG",
				(rs, rowNum) -> new String(rs.getString(1)));
	}
}
