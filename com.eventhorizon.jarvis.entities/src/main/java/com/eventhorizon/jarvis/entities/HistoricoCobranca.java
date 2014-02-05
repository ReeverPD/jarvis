package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the HistoricoCobranca database table.
 * 
 */
@Entity
public class HistoricoCobranca extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 944348287513968166L;

	@Getter @Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCobranca;

	@Getter @Setter
	private String idMoipCobranca;
	
	@Getter @Setter
	@Lob
	private String obs;
	
	@Getter @Setter
	private String statusAnterior;
	
	@Getter @Setter
	private String statusCobranca;
	
	@Getter @Setter
	private String statusProcessamento;
	
	@Getter @Setter
	private int totalCompromissos;
	
	@Getter @Setter
	private float totalDesconto;
	
	@Getter @Setter
	private float valorTotal;
	
	@Getter @Setter
	private float valorUnitario;

	//bi-directional many-to-one association to DadosCobranca
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_DadosCobranca")	
	private DadosCobranca dadosCobranca;

	
}