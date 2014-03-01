package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the JOB database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job extends AbstractEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7541911921751907048L;

	@Getter @Setter
	private String cronTime;

	@Getter @Setter
	private String instanceName;
	
	@Getter @Setter
	private String nome;
	
	//bi-directional many-to-one association to JobExecution
	@Getter @Setter
	@OneToMany(mappedBy="job")
	private List<JobExecution> jobExections;

	public JobExecution addJobExection(JobExecution jobExection) {
		getJobExections().add(jobExection);
		jobExection.setJob(this);

		return jobExection;
	}

	public JobExecution removeJobExection(JobExecution jobExection) {
		getJobExections().remove(jobExection);
		jobExection.setJob(null);

		return jobExection;
	}

}