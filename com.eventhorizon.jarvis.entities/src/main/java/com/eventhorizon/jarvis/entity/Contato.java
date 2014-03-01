package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the Contato database table.
 * 
 */
@Entity
@NamedQuery(name="Contato.findAll", query="SELECT c FROM Contato c")
public class Contato extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -4449994898303294184L;

	@Getter @Setter
	private String assunto;

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	@Lob
	private String mensagem;
	
	@Getter @Setter
	private String nome;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	private User user;

	
}