package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Agenda database table.
 * 
 */
@Entity
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String aberta;
	private int diaSemanaFim;
	private int diaSemanaInicio;
	private float minutosCompromisso;
	private String nomeAgenda;
	private User user;
	private List<Compromisso> compromissos;

	public Agenda() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAberta() {
		return this.aberta;
	}

	public void setAberta(String aberta) {
		this.aberta = aberta;
	}


	public int getDiaSemanaFim() {
		return this.diaSemanaFim;
	}

	public void setDiaSemanaFim(int diaSemanaFim) {
		this.diaSemanaFim = diaSemanaFim;
	}


	public int getDiaSemanaInicio() {
		return this.diaSemanaInicio;
	}

	public void setDiaSemanaInicio(int diaSemanaInicio) {
		this.diaSemanaInicio = diaSemanaInicio;
	}


	public float getMinutosCompromisso() {
		return this.minutosCompromisso;
	}

	public void setMinutosCompromisso(float minutosCompromisso) {
		this.minutosCompromisso = minutosCompromisso;
	}


	public String getNomeAgenda() {
		return this.nomeAgenda;
	}

	public void setNomeAgenda(String nomeAgenda) {
		this.nomeAgenda = nomeAgenda;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="agenda")
	public List<Compromisso> getCompromissos() {
		return this.compromissos;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}

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