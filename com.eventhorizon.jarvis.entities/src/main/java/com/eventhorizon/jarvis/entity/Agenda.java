package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the Agenda database table.
 * 
 */
@Entity
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda extends AbstractEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2562099753309646898L;

	@Getter @Setter
	private String aberta;

	@Getter @Setter
	private int diaSemanaFim;
	
	@Getter @Setter
	private int diaSemanaInicio;
	
	@Getter @Setter
	private float minutosCompromisso;
	
	@Getter @Setter
	private String nomeAgenda;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	private User user;
	
	//bi-directional many-to-one association to Compromisso
	@Getter @Setter
	@OneToMany(mappedBy="agenda")
	private List<Compromisso> compromissos;


	public Compromisso addCompromisso(Compromisso compromisso) {
		getCompromissos().add(compromisso);
		compromisso.setAgenda(this);

		return compromisso;
	}

	public Compromisso removeCompromisso(Compromisso compromisso) {
		getCompromissos().remove(compromisso);
		compromisso.setAgenda(null);

		return compromisso;
	}

}