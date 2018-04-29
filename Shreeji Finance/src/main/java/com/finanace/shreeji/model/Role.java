package com.finanace.shreeji.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.finanace.shreeji.type.RoleType;

@Entity
@Table(name = "master_role")
public class Role {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type="uuid-char")
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "name", columnDefinition = "enum('ADMIN','EMPLOYEE')")
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "*Please provide role type")
	private RoleType name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public RoleType	 getName() {
		return name;
	}

	public void setName(RoleType name) {
		this.name = name;
	}
}