package com.genuinehire.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column(name = "job_name")
    private String jobName;

    @NotEmpty
    @Column(name = "job_description")
    private String jobDescription;

    @Column(name="skills")
	@ElementCollection(targetClass=String.class, fetch = FetchType.EAGER)
	private List<String> skills;
    
    @NotNull
    @Column(name = "job_salary")
    private Integer salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Employer employer;

    @ManyToMany
    private Set<JobSeeker> jobSeekers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
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
	 * @return the jobSeekers
	 */
	public Set<JobSeeker> getJobSeekers() {
		return jobSeekers;
	}

	/**
	 * @param jobSeekers the jobSeekers to set
	 */
	public void setJobSeekers(Set<JobSeeker> jobSeekers) {
		this.jobSeekers = jobSeekers;
	}

 
}
