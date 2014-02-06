package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the ItemCobranca database table.
 * 
 */
@Entity
public class ItemCobranca extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -3101885668646515516L;

	@Getter @Setter
	private int itens;

	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private float taxa;
	
	@Getter @Setter
	private float valorUnitario;
	
	//bi-directional many-to-one association to HistoricoCobranca
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_HistoricoCobranca")
	private HistoricoCobranca historicoCobranca;

	
}