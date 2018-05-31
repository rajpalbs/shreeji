package com.finanace.shreeji.service;

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
}