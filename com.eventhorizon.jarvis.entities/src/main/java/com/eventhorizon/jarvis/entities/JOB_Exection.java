package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the JOB_Exection database table.
 * 
 */
@Entity
public class JOB_Exection extends AbstractEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6048626075185367441L;

	@Getter @Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	@Getter @Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date execTime;
	
	@Lob
	@Getter @Setter
	private String output;
	
	//bi-directional many-to-one association to Job
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_JOB")
	private Job job;

}