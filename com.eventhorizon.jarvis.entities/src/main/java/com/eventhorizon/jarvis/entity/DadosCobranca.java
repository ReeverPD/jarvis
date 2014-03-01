package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the DadosCobranca database table.
 * 
 */
@Entity
@NamedQuery(name="DadosCobranca.findAll", query="SELECT d FROM DadosCobranca d")
public class DadosCobranca extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 2715102106320247426L;

	@Getter @Setter
	private String diaVencimento;

	@Getter @Setter
	private String documento;
	
	@Getter @Setter
	private String endereco;
	
	@Getter @Setter
	private String isBoleto;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String tipoPagamento;
	
	//bi-directional many-to-one association to User
	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id_User")
	private User user;
	
	//bi-directional many-to-one association to HistoricoCobranca
	@Getter @Setter
	@OneToMany(mappedBy="dadosCobranca")
	private List<HistoricoCobranca> historicoCobrancas;

	/**
	 * 
	 * @param historicoCobranca
	 * @return
	 */
	public HistoricoCobranca addHistoricoCobranca(HistoricoCobranca historicoCobranca) {
		getHistoricoCobrancas().add(historicoCobranca);
		historicoCobranca.setDadosCobranca(this);
		return historicoCobranca;
	}

	
	/**
	 * 
	 * @param historicoCobranca
	 * @return
	 */
	public HistoricoCobranca removeHistoricoCobranca(HistoricoCobranca historicoCobranca) {
		getHistoricoCobrancas().remove(historicoCobranca);
		historicoCobranca.setDadosCobranca(null);
		return historicoCobranca;
	}

}