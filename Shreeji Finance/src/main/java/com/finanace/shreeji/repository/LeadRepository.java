package com.finanace.shreeji.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.bo.Customer;
import com.finanace.shreeji.bo.Financer;
import com.finanace.shreeji.bo.Lead;
import com.finanace.shreeji.bo.LeadRowMapper;
import com.finanace.shreeji.bo.Loan;
import com.finanace.shreeji.bo.Vehicle;

@Repository
public class LeadRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Lead lead){

		Customer customer = lead.getCustomer();
		Vehicle vehicle = lead.getVehicle();
		
		jdbcTemplate.update("INSERT INTO LEAD VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",
				lead.getId(),lead.getStatus(),lead.getGivenBy(),lead.getInquiryDate(),
				customer.getName(),customer.getMobileNumber1(),customer.getMobileNumber2(),customer.getVillage(),customer.getTaluka(),customer.getDistrict(),
				"","","","",
				vehicle.getName(),vehicle.getCondition(),vehicle.getRegistrationNumber(),vehicle.getManufactureYear(),vehicle.getType(),
				0,"","");
	}

	public Optional<Lead> findById(String id) {
		return jdbcTemplate.queryForObject("SELECT * FROM LEAD WHERE ID = ?",new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(
                        		new Lead(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        				rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
                        				rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
                        				rs.getString(15),rs.getString(16),rs.getString(17),rs.getInt(18),rs.getString(19),
                        				rs.getInt(20),rs.getString(21),rs.getString(22),null)
                        		)
                );	
	}
	

	public Optional<Lead> findBySearchString(String searchString) {
		return jdbcTemplate.queryForObject("SELECT * FROM LEAD WHERE ID = ? OR CUSTOMER_MOBILE_NUMBER_1 = ? OR CUSTOMER_MOBILE_NUMBER_2 = ? "
				+ "OR  CUSTOMER_NAME = ? OR VEHICLE_REGISTRATION_NUMBER = ? LIMIT 1",new Object[]{searchString,searchString,searchString,searchString,searchString},
                (rs, rowNum) ->
                        Optional.of(
                        		new Lead(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        				rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
                        				rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
                        				rs.getString(15),rs.getString(16),rs.getString(17),rs.getInt(18),rs.getString(19),
                        				rs.getInt(20),rs.getString(21),rs.getString(22),null)
                        		)
                );	
	}

	public void updateLead(Lead lead) {
		
		Customer customer = lead.getCustomer();
		Financer financer = lead.getFinancer();
		Vehicle vehicle = lead.getVehicle();
		Loan loan = lead.getLoan();
		
		this.jdbcTemplate.update(
                " UPDATE LEAD SET STATUS = ? , GIVEN_BY = ? , INQUIRY_DATE = ? , "
                + " CUSTOMER_NAME = ? , CUSTOMER_MOBILE_NUMBER_1 =? , CUSTOMER_MOBILE_NUMBER_2 = ? , CUSTOMER_VILLAGE = ? , CUSTOMER_TALUKA = ? , CUSTOMER_DISTRICT = ? , "
                + " FINANCE_BANK_NAME = ? , FINANCE_EXECUTIVE_NAME = ? , FINANCE_EXECUTIVE_NUMBER = ? , FINANCE_AGREEMENT_DONE = ? ,"
                + " VEHICLE_NAME = ? , VEHICLE_CONDITION = ? , VEHICLE_REGISTRATION_NUMBER = ? , VEHICLE_MANUFACTURE_YEAR = ? , VEHICLE_TYPE = ? , "
                + " LOAN_AMOUNT = ? , LOAN_NUMBER = ? , LOAN_DATE = ? WHERE ID = ?", 
                lead.getStatus(), lead.getGivenBy() , lead.getInquiryDate(),
                customer.getName(),customer.getMobileNumber1(),customer.getMobileNumber2(),customer.getVillage(),customer.getTaluka(),customer.getDistrict(),
                financer.getBankName(),financer.getExecutiveName(),financer.getMobileNumber(),financer.getAgreementDone(),
                vehicle.getName(),vehicle.getCondition(),vehicle.getRegistrationNumber(),vehicle.getManufactureYear(),vehicle.getType(),
                loan.getLoanAmount(),loan.getLoanNumber(),loan.getLoanDate(),lead.getId());
	}

	public List<Lead> getLeadsBetweenDates(String fromDate, String toDate) {
		return jdbcTemplate.query("SELECT * FROM LEAD where STR_TO_DATE(INQUIRY_DATE,'%d-%b-%Y') >= STR_TO_DATE('"+fromDate+"','%d-%b-%Y') "
				+ "and STR_TO_DATE(INQUIRY_DATE,'%d-%b-%Y') <= STR_TO_DATE('"+toDate+"','%d-%b-%Y')",new LeadRowMapper());
	}
}
