package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Contato database table.
 * 
 */
@Entity
@NamedQuery(name="Contato.findAll", query="SELECT c FROM Contato c")
public class Contato extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String assunto;
	private String email;
	private String mensagem;
	private String nome;
	private User user;

	public Contato() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Lob
	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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