package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_Exection database table.
 * 
 */
@Entity
@NamedQuery(name="JOB_Exection.findAll", query="SELECT j FROM JOB_Exection j")
public class JOB_Exection extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date endTime;
	private Date execTime;
	private String output;
	private Job job;

	public JOB_Exection() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getExecTime() {
		return this.execTime;
	}

	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}


	@Lob
	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}


	//bi-directional many-to-one association to Job
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_JOB")
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}