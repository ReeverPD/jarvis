package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DadosCobranca database table.
 * 
 */
@Entity
@NamedQuery(name="DadosCobranca.findAll", query="SELECT d FROM DadosCobranca d")
public class DadosCobranca extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String diaVencimento;
	private String documento;
	private String endereco;
	private String isBoleto;
	private String nome;
	private String tipoPagamento;
	private User user;
	private List<HistoricoCobranca> historicoCobrancas;

	public DadosCobranca() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDiaVencimento() {
		return this.diaVencimento;
	}

	public void setDiaVencimento(String diaVencimento) {
		this.diaVencimento = diaVencimento;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getIsBoleto() {
		return this.isBoleto;
	}

	public void setIsBoleto(String isBoleto) {
		this.isBoleto = isBoleto;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipoPagamento() {
		return this.tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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


	//bi-directional many-to-one association to HistoricoCobranca
	@OneToMany(mappedBy="dadosCobranca")
	public List<HistoricoCobranca> getHistoricoCobrancas() {
		return this.historicoCobrancas;
	}

	public void setHistoricoCobrancas(List<HistoricoCobranca> historicoCobrancas) {
		this.historicoCobrancas = historicoCobrancas;
	}

	public HistoricoCobranca addHistoricoCobranca(HistoricoCobranca historicoCobranca) {
		getHistoricoCobrancas().add(historicoCobranca);
		historicoCobranca.setDadosCobranca(this);

		return historicoCobranca;
	}

	public HistoricoCobranca removeHistoricoCobranca(HistoricoCobranca historicoCobranca) {
		getHistoricoCobrancas().remove(historicoCobranca);
		historicoCobranca.setDadosCobranca(null);

		return historicoCobranca;
	}

}