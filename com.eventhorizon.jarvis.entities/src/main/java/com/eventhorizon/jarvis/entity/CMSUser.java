package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the CMSUsers database table.
 * 
 */
@Entity
@Table(name="CMSUsers")
@NamedQuery(name="CMSUser.findAll", query="SELECT c FROM CMSUser c")
public class CMSUser extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -8758681200474185698L;

	@Getter @Setter
	private String ativo;

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String picture;
	
	@Getter @Setter
	private String username;

	
}