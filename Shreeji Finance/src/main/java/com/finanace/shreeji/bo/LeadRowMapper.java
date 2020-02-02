package com.finanace.shreeji.bo;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LeadRowMapper implements RowMapper<Lead> {

    @Override
    public Lead mapRow(ResultSet rs, int rowNum) throws SQLException {

        Lead lead = new Lead();

        lead.setId(rs.getString("ID"));
        lead.setStatus(rs.getString("STATUS"));
        lead.setGivenBy(rs.getString("GIVEN_BY"));
        lead.setInquiryDate(rs.getString("INQUIRY_DATE"));
                
        lead.setCustomer(new Customer(rs.getString("CUSTOMER_NAME"), rs.getString("CUSTOMER_MOBILE_NUMBER_1"), rs.getString("CUSTOMER_MOBILE_NUMBER_2"), rs.getString("CUSTOMER_VILLAGE"), rs.getString("CUSTOMER_TALUKA"), rs.getString("CUSTOMER_DISTRICT")));
        
        lead.setFinancer(new Financer(rs.getString("FINANCE_BANK_NAME"), rs.getString("FINANCE_EXECUTIVE_NAME"), rs.getString("FINANCE_EXECUTIVE_NUMBER"), rs.getString("FINANCE_AGREEMENT_DONE")));

        lead.setVehicle(new Vehicle(rs.getString("VEHICLE_NAME"), rs.getString("VEHICLE_CONDITION"), rs.getString("VEHICLE_REGISTRATION_NUMBER"), rs.getInt("VEHICLE_MANUFACTURE_YEAR"), rs.getString("VEHICLE_TYPE")));

        lead.setLoan(new Loan(rs.getString("LOAN_DATE"), rs.getString("LOAN_NUMBER"), rs.getInt("LOAN_AMOUNT")));
        
        return lead;
    }
}