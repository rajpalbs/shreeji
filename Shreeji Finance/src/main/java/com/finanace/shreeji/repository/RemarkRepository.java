package com.finanace.shreeji.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.bo.Remark;

@Repository
public class RemarkRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(String leadId, String remark) {
		jdbcTemplate.update("INSERT INTO REMARK VALUES(?,?,?)", leadId,
				new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), remark);
	}

	public List<Remark> getAllRemarksOfLead(String leadId) {
		List<Remark> remarks = jdbcTemplate.query("SELECT * FROM REMARK WHERE LEAD_ID = "+leadId, new BeanPropertyRowMapper<Remark>(Remark.class));
		return remarks;		
	}
}
