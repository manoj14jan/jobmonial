package com.genuinehire.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 11;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long adminId;

	@NotEmpty
	@Size(min = 4, max = 50)
	@Column(name = "first_name")
	private String firstName;

	@Size(min = 0, max = 50)
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty
	@Pattern(regexp = "^(\\([0-9]{3}\\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$",message = "{valid.phone}")
	@Column(name = "phone")
	private String phone;

	@Email
	@NotEmpty
	@Column(name = "email")
	private String email;

}
