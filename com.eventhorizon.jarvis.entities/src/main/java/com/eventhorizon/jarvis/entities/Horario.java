package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date DIa;
	private Time horarioFim;
	private Time horarioInicio;
	private String obs;
	private String status;
	private Compromisso compromisso;
	private Horario horario;
	private List<Horario> horarios;

	public Horario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getDIa() {
		return this.DIa;
	}

	public void setDIa(Date DIa) {
		this.DIa = DIa;
	}


	public Time getHorarioFim() {
		return this.horarioFim;
	}

	public void setHorarioFim(Time horarioFim) {
		this.horarioFim = horarioFim;
	}


	public Time getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Time horarioInicio) {
		this.horarioInicio = horarioInicio;
	}


	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	//bi-directional many-to-one association to Compromisso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Compromisso")
	public Compromisso getCompromisso() {
		return this.compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}


	//bi-directional many-to-one association to Horario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Horario_Pai")
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}


	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="horario")
	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setHorario(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setHorario(null);

		return horario;
	}

}