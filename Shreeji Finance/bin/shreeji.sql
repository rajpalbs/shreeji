DROP DATABASE IF EXISTS shreeji;
CREATE DATABASE shreeji; 
USE shreeji;

DROP TABLE IF EXISTS master_insurance;
DROP TABLE IF EXISTS detail_loan;
DROP TABLE IF EXISTS master_loan;
DROP TABLE IF EXISTS master_customer;
DROP TABLE IF EXISTS master_employee;
DROP TABLE IF EXISTS master_branch;
DROP TABLE IF EXISTS master_role;

CREATE TABLE master_role (
  id varchar(36) NOT NULL PRIMARY KEY,
  name ENUM('ADMIN','EMPLOYEE') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `master_role` VALUES (uuid(),'ADMIN');


CREATE TABLE master_branch (
	id varchar(36) NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL UNIQUE,
    city varchar(15) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `master_branch` values(uuid(),"MODASA (MAIN)","MODASA");
INSERT INTO `master_branch` values(uuid(),"MEGHRAJ (MAIN)","MEGHRAJ");

CREATE TABLE master_employee(
	id varchar(36) NOT NULL PRIMARY KEY,
	name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
    status TINYINT(1) DEFAULT 0,
    branch_id varchar(36) NOT NULL,
    role_id varchar(36) NOT NULL, 
    FOREIGN KEY (branch_id) REFERENCES master_branch(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES master_role(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE master_customer (
	id varchar(36) NOT NULL PRIMARY KEY,
    fullname varchar(255) NOT NULL,
    address varchar(1024),
    contact_number varchar(15),
	created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE master_loan ( 
	id varchar(36) NOT NULL PRIMARY KEY,
	customer_id varchar(36) NOT NULL,
    loan_type ENUM('VEHICLE','HOME','KCC') NOT NULL,
	inquiry_date DATE NOT NULL,
    branch_id varchar(36) NOT NULL,
    employee_id varchar(36) NOT NULL,
    status ENUM('PASS','PENDING','CANCELLED') NOT NULL,
    loan_amount float(10,2) NOT NULL,
    commission_amount float(10,2) NOT NULL,
	created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES master_customer(id) ON DELETE CASCADE,
    FOREIGN KEY (branch_id) REFERENCES master_branch(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES master_employee(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE detail_loan ( 
	id varchar(36) NOT NULL PRIMARY KEY,
    loan_id varchar(36) NOT NULL,
    config_name varchar(36) NOT NULL,
    config_value varchar(255) NOT NULL,
	FOREIGN KEY (loan_id) REFERENCES master_loan(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE master_insurance(
	id varchar(36) NOT NULL PRIMARY KEY,
	customer_id varchar(36) NOT NULL,	
    branch_id varchar(36) NOT NULL,
    employee_id varchar(36) NOT NULL,
	vehicle_name varchar(255),
    vehicle_registration_number varchar(15),
    vehicle_manufacturing_year int(4),
    insurance_start_date date NOT NULL,
    insurance_end_date date NOT NULL,
    insurance_company_name varchar(32),
    value float(10,2),
    od_premium_amount float(10,2),
    total_premium float(10,2),
	created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES master_customer(id) ON DELETE CASCADE,
    FOREIGN KEY (branch_id) REFERENCES master_branch(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES master_employee(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE LEAD;
CREATE TABLE LEAD (
	ID VARCHAR(10) PRIMARY KEY,
	STATUS ENUM('OPEN','FOLLOW_UP','SENCTIONED','CANCELLED','DELETE'),
	GIVEN_BY VARCHAR(36) NOT NULL,
	INQUIRY_DATE varchar(11) NOT NULL,
	CUSTOMER_NAME VARCHAR(36) NOT NULL,
	CUSTOMER_MOBILE_NUMBER_1 VARCHAR(10) NOT NULL,
	CUSTOMER_MOBILE_NUMBER_2 VARCHAR(10),
	CUSTOMER_VILLAGE VARCHAR(20) NOT NULL,
	CUSTOMER_TALUKA VARCHAR(20) NOT NULL,
	CUSTOMER_DISTRICT VARCHAR(20) NOT NULL,
	FINANCE_BANK_NAME VARCHAR(50),
	FINANCE_EXECUTIVE_NAME VARCHAR(50),
	FINANCE_EXECUTIVE_NUMBER VARCHAR(50),
	FINANCE_AGREEMENT_DONE varchar(32),
	VEHICLE_NAME VARCHAR(20) NOT NULL,
	VEHICLE_CONDITION ENUM('NEW','OLD','RC') NOT NULL,
	VEHICLE_REGISTRATION_NUMBER VARCHAR(10) NOT NULL,
	VEHICLE_MANUFACTURE_YEAR VARCHAR(4) NOT NULL,
	VEHICLE_TYPE ENUM('CAR','FES','CV','3W'), 
	LOAN_AMOUNT INT,
	LOAN_NUMBER VARCHAR(20),
	LOAN_DATE varchar(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE LEAD ( LOAN_DATE varchar(11) )ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from lead

DROP TABLE CONFIG;
CREATE TABLE CONFIG (
	AGENT_NAMES VARCHAR(1000) NOT NULL,
	FINANCE_BANKS VARCHAR(1000) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into CONFIG  values('PRADEEPSINH HADA,DILIP','KOTAK,AUM,MAHINDRA');

DROP TABLE REMARK;
CREATE TABLE REMARK(
	LEAD_ID VARCHAR(10) NOT NULL,
	DATE varchar(11) NOT NULL,
	REMARK varchar(1000) NOT NULL,
	FOREIGN KEY (LEAD_ID) REFERENCES LEAD(ID) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Report Procedure
DROP PROCEDURE IF EXISTS loan_report;

CREATE PROCEDURE loan_report(from_date timestamp,to_date timestamp)
BEGIN  
	select mc.fullname as customername,
	   mc.contact_number as customercontactnumber,
	   CONCAT(me.name, ' ', me.surname)   as employeename,
	   mb.name as loanbranchname,
	   ml.inquiry_date as loaninsuirydate,
	   ml.loan_amount as loanamount,
	   ml.commission_amount as commissionamount,
	   ml.loan_type as loantype,
	   GROUP_CONCAT(dl.config_name,'#',dl.config_value) as detailloandata
	from master_loan ml inner join master_customer mc on mc.id = ml.customer_id and date(ml.created_at) between date(from_date) and date(to_date)  
	inner join master_employee me on me.id = ml.employee_id
	inner join master_branch mb on mb.id = me.branch_id
	inner join detail_loan dl on dl.loan_id = ml.id
	group by ml.id
	order by ml.created_at;
END

commit;
