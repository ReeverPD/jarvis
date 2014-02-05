package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the Horario database table.
 * 
 */
@Entity
public class Horario extends AbstractEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6828256657832309029L;

	@Getter @Setter
	@Temporal(TemporalType.DATE)
	private Date DIa;

	@Getter @Setter
	private Time horarioFim;
	
	@Getter @Setter
	private Time horarioInicio;
	
	@Getter @Setter
	private String obs;
	
	@Getter @Setter
	private String status;
	
	//bi-directional many-to-one association to Compromisso
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Compromisso")
	private Compromisso compromisso;
	
	//bi-directional many-to-one association to Horario
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Horario_Pai")
	private Horario horario;
	
	//bi-directional many-to-one association to Horario
	@Getter @Setter
	@OneToMany(mappedBy="horario")
	private List<Horario> horarios;

	/**
	 * 
	 * @param horario
	 * @return
	 */
	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setHorario(this);

		return horario;
	}

	/**
	 * 
	 * @param horario
	 * @return
	 */
	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setHorario(null);

		return horario;
	}

}