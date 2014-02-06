package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the Vertical database table.
 * 
 */
@Entity
@NamedQuery(name="Vertical.findAll", query="SELECT v FROM Vertical v")
public class Vertical extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8636028641369469022L;

	@Getter @Setter
	private String ativo;

	@Getter @Setter
	private String nome;

	// bi-directional many-to-one association to VerticalUser
	@Getter @Setter
	@OneToMany(mappedBy = "vertical")
	private List<VerticalUser> verticalUsers;

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