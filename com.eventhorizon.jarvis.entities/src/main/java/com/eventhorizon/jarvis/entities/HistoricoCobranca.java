package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HistoricoCobranca database table.
 * 
 */
@Entity
@NamedQuery(name="HistoricoCobranca.findAll", query="SELECT h FROM HistoricoCobranca h")
public class HistoricoCobranca extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dataCobranca;
	private String idMoipCobranca;
	private String obs;
	private String statusAnterior;
	private String statusCobranca;
	private String statusProcessamento;
	private int totalCompromissos;
	private float totalDesconto;
	private float valorTotal;
	private float valorUnitario;
	private DadosCobranca dadosCobranca;

	public HistoricoCobranca() {
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
	public Date getDataCobranca() {
		return this.dataCobranca;
	}

	public void setDataCobranca(Date dataCobranca) {
		this.dataCobranca = dataCobranca;
	}


	public String getIdMoipCobranca() {
		return this.idMoipCobranca;
	}

	public void setIdMoipCobranca(String idMoipCobranca) {
		this.idMoipCobranca = idMoipCobranca;
	}


	@Lob
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getStatusAnterior() {
		return this.statusAnterior;
	}

	public void setStatusAnterior(String statusAnterior) {
		this.statusAnterior = statusAnterior;
	}


	public String getStatusCobranca() {
		return this.statusCobranca;
	}

	public void setStatusCobranca(String statusCobranca) {
		this.statusCobranca = statusCobranca;
	}


	public String getStatusProcessamento() {
		return this.statusProcessamento;
	}

	public void setStatusProcessamento(String statusProcessamento) {
		this.statusProcessamento = statusProcessamento;
	}


	public int getTotalCompromissos() {
		return this.totalCompromissos;
	}

	public void setTotalCompromissos(int totalCompromissos) {
		this.totalCompromissos = totalCompromissos;
	}


	public float getTotalDesconto() {
		return this.totalDesconto;
	}

	public void setTotalDesconto(float totalDesconto) {
		this.totalDesconto = totalDesconto;
	}


	public float getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}


	public float getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	//bi-directional many-to-one association to DadosCobranca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_DadosCobranca")
	public DadosCobranca getDadosCobranca() {
		return this.dadosCobranca;
	}

	public void setDadosCobranca(DadosCobranca dadosCobranca) {
		this.dadosCobranca = dadosCobranca;
	}

}