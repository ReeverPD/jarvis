package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ConversaCompromisso database table.
 * 
 */
@Entity
@NamedQuery(name="ConversaCompromisso.findAll", query="SELECT c FROM ConversaCompromisso c")
public class ConversaCompromisso extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date data;
	private String texto;
	private Compromisso compromisso;
	private User user;

	public ConversaCompromisso() {
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
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	@Lob
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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


	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}