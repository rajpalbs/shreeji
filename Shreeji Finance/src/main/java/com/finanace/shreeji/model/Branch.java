package com.finanace.shreeji.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "master_branch")
public class Branch {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "name", unique = true)
	@Length(max = 255, message = "*Branch name should not be more than 255 character.")
	private String name;

	@Column(name = "city")
	@Length(max = 15, message = "*City name should not be more than 15 character.")
	private String city;

	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
