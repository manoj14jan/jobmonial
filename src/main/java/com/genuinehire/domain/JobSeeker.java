package com.genuinehire.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "job_seeker")
public class JobSeeker implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -211385439151493237L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long jobSeekerId;

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
	
	@NotEmpty
	@Size(min = 4, max = 200)
	@Column(name = "profile_title")
	private String profileTitle;

	@Column(name="skills")
	@ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
	private List<String> skills;
	
	@Column(name = "experience")
	private Integer experience;

	@Column(name = "about_you", columnDefinition = "TEXT")
	private String aboutYou;

	@Column(name = "status")
	private String status;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	/**
	 * @return the jobSeekerId
	 */
	public Long getJobSeekerId() {
		return jobSeekerId;
	}

	/**
	 * @param jobSeekerId the jobSeekerId to set
	 */
	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the skills
	 */
	public List<String> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	/**
	 * @return the experience
	 */
	public Integer getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	/**
	 * @return the aboutYou
	 */
	public String getAboutYou() {
		return aboutYou;
	}

	/**
	 * @param aboutYou the aboutYou to set
	 */
	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the profileTitle
	 */
	public String getProfileTitle() {
		return profileTitle;
	}

	/**
	 * @param profileTitle the profileTitle to set
	 */
	public void setProfileTitle(String profileTitle) {
		this.profileTitle = profileTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
