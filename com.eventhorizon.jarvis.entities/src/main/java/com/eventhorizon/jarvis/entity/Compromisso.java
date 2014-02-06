package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the Compromisso database table.
 * 
 */
@Entity
public class Compromisso extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -2525823978555406470L;

	@Getter @Setter
	@Lob
	private String descricao;

	@Getter @Setter
	private String titulo;
	
	//bi-directional many-to-one association to Agenda
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Agenda")
	private Agenda agenda;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User_From")
	private User userFrom;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User_To")
	private User userTo;
	
	//bi-directional many-to-one association to ConversaCompromisso
	@Getter @Setter
	@OneToMany(mappedBy="compromisso")
	private List<ConversaCompromisso> conversaCompromissos;
	
	//bi-directional many-to-one association to Horario
	@Getter @Setter
	@OneToMany(mappedBy="compromisso")
	private List<Horario> horarios;

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