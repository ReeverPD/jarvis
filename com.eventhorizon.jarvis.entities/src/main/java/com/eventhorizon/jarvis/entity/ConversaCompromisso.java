package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the ConversaCompromisso database table.
 * 
 */
@Entity
@NamedQuery(name="ConversaCompromisso.findAll", query="SELECT c FROM ConversaCompromisso c")
public class ConversaCompromisso extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8475985093616107148L;

	@Getter @Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Getter @Setter
	@Lob
	private String texto;
	
	//bi-directional many-to-one association to Compromisso
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Compromisso")
	private Compromisso compromisso;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	private User user;


}