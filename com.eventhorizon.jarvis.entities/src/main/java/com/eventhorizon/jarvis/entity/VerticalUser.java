package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the VerticalUser database table.
 * 
 */
@Entity
public class VerticalUser extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -3315232705827669116L;

	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	private User user;
	
	//bi-directional many-to-one association to Vertical
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_Vertical")
	private Vertical vertical;

}