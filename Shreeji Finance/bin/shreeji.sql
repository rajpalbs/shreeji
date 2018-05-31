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
    contact_number varchar(15)
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
    branch_id varchar(36) NOT NULL,
    employee_id varchar(36) NOT NULL,
    fullname varchar(255) NOT NULL,
	address varchar(1024),
    contact_number varchar(15),
	vehicle_name varchar(255),
    vehicle_registration_number varchar(15),
    vehicle_manufacturing_year int(4),
    insurance_start_date date NOT NULL,
    insurance_end_date date NOT NULL,
    insurance_company_name varchar(32),
    value float(10,2),
    od_premium_amount float(10,2),
    total_premium float(10,2),
    FOREIGN KEY (branch_id) REFERENCES master_branch(id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES master_employee(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;