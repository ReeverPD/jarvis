package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Vertical database table.
 * 
 */
@Entity
@NamedQuery(name="Vertical.findAll", query="SELECT v FROM Vertical v")
public class Vertical extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String ativo;
	private String nome;
	private List<VerticalUser> verticalUsers;

	public Vertical() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	//bi-directional many-to-one association to VerticalUser
	@OneToMany(mappedBy="vertical")
	public List<VerticalUser> getVerticalUsers() {
		return this.verticalUsers;
	}

	public void setVerticalUsers(List<VerticalUser> verticalUsers) {
		this.verticalUsers = verticalUsers;
	}

	public VerticalUser addVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().add(verticalUser);
		verticalUser.setVertical(this);

		return verticalUser;
	}

	public VerticalUser removeVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().remove(verticalUser);
		verticalUser.setVertical(null);

		return verticalUser;
	}

}