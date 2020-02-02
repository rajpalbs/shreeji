package com.finanace.shreeji.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Customer;
import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.model.Loan;
import com.finanace.shreeji.model.LoanDetail;
import com.finanace.shreeji.model.dto.LoanReportDTO;
import com.finanace.shreeji.repository.CustomerRepository;
import com.finanace.shreeji.repository.EmployeeRepository;
import com.finanace.shreeji.repository.LoanDetailsRepository;
import com.finanace.shreeji.repository.LoanRepository;
import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.LoanServiceRequest;
import com.finanace.shreeji.service.dto.VehicleLoanServiceRequest;
import com.finanace.shreeji.type.CancelledLoanAttributeType;
import com.finanace.shreeji.type.LoanType;
import com.finanace.shreeji.type.PassLoanAttributeType;
import com.finanace.shreeji.type.PendingLoanAttributeType;
import com.finanace.shreeji.type.VehicleLoanAttributeType;

@Service("loanService")
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private LoanDetailsRepository loanDetailsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void createLoanWithCustomer(LoanServiceRequest loanServiceRequest,
			CustomerServiceRequest customerServiceRequest) {

		Loan loanEntity = new Loan();
		
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.getUsername();
		Employee employee = employeeRepository.findByEmail(username);
		loanEntity.setEmployee(employee);
		loanEntity.setBranch(employee.getBranch());
		
		// create customer
		Customer customerEntity = new Customer();
		BeanUtils.copyProperties(customerServiceRequest, customerEntity);
		customerEntity = customerRepository.save(customerEntity);

		// Create master Loan for customer
		BeanUtils.copyProperties(loanServiceRequest, loanEntity);
		loanEntity.setCustomer(customerEntity);
		
		loanRepository.save(loanEntity);
		// Create Detail Loan
		switch (loanEntity.getLoanStatus()) {
		case PASS:
			saveLoanDetails(loanEntity, PassLoanAttributeType.LOAN_NUMBER.name(), loanServiceRequest.getLoanNumber());
			saveLoanDetails(loanEntity, PassLoanAttributeType.LOAN_DATE.name(), loanServiceRequest.getLoanDate().toString());
			saveLoanDetails(loanEntity, PassLoanAttributeType.LOAN_COMMISSION_AMOUNT.name(), ""+loanServiceRequest.getLoanCommissionAmount());
			break;
		case PENDING:
			saveLoanDetails(loanEntity, PendingLoanAttributeType.LOAN_PENDING_REASON.name(), loanServiceRequest.getPendingRemark());
			break;
		case CANCELLED:
			saveLoanDetails(loanEntity, CancelledLoanAttributeType.LOAN_CANCEL_REASON.name(), loanServiceRequest.getCancelRemark());
			break;	
		default:
			break;
		}
		if(loanServiceRequest.getLoanType() == LoanType.VEHICLE){
			VehicleLoanServiceRequest vehicleLoanServiceRequest = (VehicleLoanServiceRequest) loanServiceRequest;
			saveLoanDetails(loanEntity, VehicleLoanAttributeType.VEHICLE_NAME.name(), vehicleLoanServiceRequest.getVehicleName());
			saveLoanDetails(loanEntity, VehicleLoanAttributeType.FINANCER_NAME.name(), vehicleLoanServiceRequest.getFinancerName());			
			if(vehicleLoanServiceRequest.getVehicleCondition().equalsIgnoreCase("old")){
				saveLoanDetails(loanEntity,VehicleLoanAttributeType.MANUFACTURING_YEAR.name(),""+vehicleLoanServiceRequest.getManufacturingYear());
			}			
		}
	}
	
	private void saveLoanDetails(Loan loan,String key,String value){
		LoanDetail loanDetail = new LoanDetail();
		loanDetail.setLoan(loan);
		loanDetail.setName(key);
		loanDetail.setValue(value);
		loanDetailsRepository.save(loanDetail);
	}
	
	@Override
	public List<LoanReportDTO> getLoanReport(Date fromDate,Date toDate){
		
		StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("loan_report");
		storedProcedureQuery.registerStoredProcedureParameter("fromDate", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("toDate", Date.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("fromDate", fromDate);
		storedProcedureQuery.setParameter("toDate", toDate);
/*		@SuppressWarnings("rawtypes")
		List resultList = storedProcedureQuery.getResultList();
*/		List<LoanReportDTO> loanReportDTO = new ArrayList<>();
		return loanReportDTO;
	}
	
	/*private void processToReportDTO(List resultList,List<LoanReportDTO> loanReportDTO){
		for(Object currentLoanRecord : resultList){
			LoanReportDTO reportDTO = new LoanReportDTO();
			Object[] data = (Object[]) currentLoanRecord;
			reportDTO.setCustomername(data[0].toString());
			reportDTO.setCustomercontactnumber(data[1].toString());
			reportDTO.setEmployeename(data[2].toString());
			reportDTO.setLoanbranchname(data[3].toString());
			reportDTO.setLoantype(data[3].toString());
			reportDTO.setLoaninquirydate(data[4].toString());
			reportDTO.setCustomercontactnumber(data[1].toString());
			reportDTO.setCustomercontactnumber(data[1].toString());
			reportDTO.setCustomercontactnumber(data[1].toString());
			
			
			
/*			   CONCAT(me.name, ' ', me.surname)   as employeename,
			   mb.name as loanbranchname,
			   ml.inquiry_date as loaninsuirydate,
			   ml.loan_amount as loanamount,
			   ml.commission_amount as commissionamount,
			   ml.loan_type as loantype,
			
			
			loanReportDTO.add(reportDTO);
/		}/
	}*/
}