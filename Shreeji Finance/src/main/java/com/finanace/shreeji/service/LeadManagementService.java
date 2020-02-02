package com.finanace.shreeji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.finanace.shreeji.bo.Lead;
import com.finanace.shreeji.bo.Remark;
import com.finanace.shreeji.repository.LeadRepository;
import com.finanace.shreeji.repository.RemarkRepository;

@Service("leadManagementService")
public class LeadManagementService {

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private RemarkRepository remarkRepository;

	public Lead saveAndRetrieveLead(Lead lead) {

		// Save Lead
		leadRepository.save(lead);

		// Retrieve Lead
		Lead generatedLead = getLeadByLeadId(lead.getId());
		
		//save remark
		if(!StringUtils.isEmpty(lead.getRemark())){
			remarkRepository.save(lead.getId(), lead.getRemark());
		}
 		return generatedLead;
	}

	public Lead getLeadByLeadId(String leadId) {
		return leadRepository.findById(leadId).orElse(null);
	}

	public Lead getLeadBySearchString(String searchString) {
		return leadRepository.findBySearchString(searchString).orElse(null);
	}

	public void updateLead(Lead lead) {
		leadRepository.updateLead(lead);
		if(!StringUtils.isEmpty(lead.getRemark())){
			remarkRepository.save(lead.getId(), lead.getRemark());
		}
	}
	
	public List<Lead> getLeadsBetweenDates(String fromDate, String toDate){
		return leadRepository.getLeadsBetweenDates(fromDate,toDate);
	}
	
	public List<Remark> getAllRemarksOfLead(String leadId){
		return remarkRepository.getAllRemarksOfLead(leadId);
	}

}
