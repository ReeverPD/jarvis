package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VerticalUser database table.
 * 
 */
@Entity
@NamedQuery(name="VerticalUser.findAll", query="SELECT v FROM VerticalUser v")
public class VerticalUser extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Vertical vertical;
	private User user;

	public VerticalUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Vertical
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Vertical")
	public Vertical getVertical() {
		return this.vertical;
	}

	public void setVertical(Vertical vertical) {
		this.vertical = vertical;
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