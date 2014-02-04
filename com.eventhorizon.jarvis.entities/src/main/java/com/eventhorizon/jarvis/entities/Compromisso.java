package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Compromisso database table.
 * 
 */
@Entity
@NamedQuery(name="Compromisso.findAll", query="SELECT c FROM Compromisso c")
public class Compromisso extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;
	private String titulo;
	private Agenda agenda;
	private User user1;
	private User user2;
	private List<ConversaCompromisso> conversaCompromissos;
	private List<Horario> horarios;

	public Compromisso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	//bi-directional many-to-one association to Agenda
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Agenda")
	public Agenda getAgenda() {
		return this.agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User_From")
	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User_To")
	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}


	//bi-directional many-to-one association to ConversaCompromisso
	@OneToMany(mappedBy="compromisso")
	public List<ConversaCompromisso> getConversaCompromissos() {
		return this.conversaCompromissos;
	}

	public void setConversaCompromissos(List<ConversaCompromisso> conversaCompromissos) {
		this.conversaCompromissos = conversaCompromissos;
	}

	public ConversaCompromisso addConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().add(conversaCompromisso);
		conversaCompromisso.setCompromisso(this);

		return conversaCompromisso;
	}

	public ConversaCompromisso removeConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().remove(conversaCompromisso);
		conversaCompromisso.setCompromisso(null);

		return conversaCompromisso;
	}


	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="compromisso")
	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setCompromisso(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setCompromisso(null);

		return horario;
	}

}