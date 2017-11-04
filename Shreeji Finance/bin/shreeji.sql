CREATE TABLE role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  active int(11) DEFAULT NULL,
  email varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE user_role (
  role_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE customer (
  customer_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  co_applicant_name varchar(255),
  garanter_name varchar(255),
  contact_no_1 varchar(15) NOT NULL,
  contact_no_2 varchar(15),
  id_proof_type ENUM('AADHAR','ELECTION_CARD','LICENCE','PASSPORT') NOT NULL,
  id_proof_value varchar(32) NOT NULL,
  address_type ENUM('OWN','RENTAL') NOT NULL,
  address varchar(1024),
  occupation_type ENUM('JOB','BUSINESS','AGRICULTURE')NOT NULL,
  salary_type ENUM('MONTHLY','YEARLY')NOT NULL,
  net_income float(10,2) NOT NULL,  
  PRIMARY KEY (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vehicle (
  vehicle_id int(11) NOT NULL AUTO_INCREMENT,
  number varchar(11) NOT NULL UNIQUE,
  vehicle_generation_type ENUM('NEW','OLD','RC_LIMIT') NOT NULL,
  vehicle_type ENUM('CAR','TRACTOR','CV','AUTO') NOT NULL,
  model_name varchar(255) NOT NULL,
  engine_number varchar(255) NOT NULL,
  chassis_number varchar(255) NOT NULL,
  mfg_year int(4) NOT NULL,
  PRIMARY KEY (vehicle_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE insurance (
  insurance_id int(11) NOT NULL AUTO_INCREMENT,
  number int(11) NOT NULL,
  vehicle_id int(11) NOT NULL,
  PRIMARY KEY (insurance_id),
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE loan (
  loan_id int(11) NOT NULL AUTO_INCREMENT,
  loan_amount float(10,2) NOT NULL,
  advance_amount float(10,2) NOT NULL,
  file_charge_amount float(10,2) NOT NULL,
  loan_insurance_amount float(10,2) NOT NULL,
  emi_amount float(10,2) NOT NULL,
  tenure_type ENUM('MONTHLY','QUATERLY','HALFYEARLY') NOT NULL,
  tenure_count int(11) NOT NULL,
  customer_id int(11) NOT NULL,
  vehicle_id int(11) NOT NULL,
  PRIMARY KEY (loan_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE,
  FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
