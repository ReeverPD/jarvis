package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JOB database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cronTime;
	private String instanceName;
	private String nome;
	private List<JOB_Exection> jobExections;

	public Job() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCronTime() {
		return this.cronTime;
	}

	public void setCronTime(String cronTime) {
		this.cronTime = cronTime;
	}


	public String getInstanceName() {
		return this.instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	//bi-directional many-to-one association to JOB_Exection
	@OneToMany(mappedBy="job")
	public List<JOB_Exection> getJobExections() {
		return this.jobExections;
	}

	public void setJobExections(List<JOB_Exection> jobExections) {
		this.jobExections = jobExections;
	}

	public JOB_Exection addJobExection(JOB_Exection jobExection) {
		getJobExections().add(jobExection);
		jobExection.setJob(this);

		return jobExection;
	}

	public JOB_Exection removeJobExection(JOB_Exection jobExection) {
		getJobExections().remove(jobExection);
		jobExection.setJob(null);

		return jobExection;
	}

}