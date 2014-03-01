package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends AbstractEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 971017548214849269L;

	@Getter @Setter
	private String activationToken;
	
	@Lob
	private String descricao;
	
	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String profile_Cover;
	
	@Getter @Setter
	private String profile_Id;
	
	@Getter @Setter
	private String profile_Link;
	
	@Getter @Setter
	private String profile_Picture;
	
	@Getter @Setter
	private String profile_Token;
	
	@Getter @Setter
	private String sobrenome;
	
	@Getter @Setter
	private String social_Media_Type;
	
	@Getter @Setter
	private String tipoUsuario;
	
	@Getter @Setter
	private String username;
	
	//bi-directional many-to-one association to Agenda
	@Getter @Setter
	@OneToMany(mappedBy="user")
	private List<Agenda> agendas;
	
	//bi-directional many-to-one association to Compromisso
	@Getter @Setter
	@OneToMany(mappedBy="userTo")
	private List<Compromisso> compromissosComUsuario;
	
	//bi-directional many-to-one association to Compromisso
	@Getter @Setter
	@OneToMany(mappedBy="userFrom")
	private List<Compromisso> compromissosDoUsuario;
	
	//bi-directional many-to-one association to Contato
	@Getter @Setter
	@OneToMany(mappedBy="user")
	private List<Contato> contatos;
	
	//bi-directional many-to-one association to ConversaCompromisso
	@Getter @Setter
	@OneToMany(mappedBy="user")
	private List<ConversaCompromisso> conversaCompromissos;
	
	//bi-directional many-to-one association to DadosCobranca
	@Getter @Setter
	@OneToMany(mappedBy="user")
	private List<DadosCobranca> dadosCobrancas;
	
	//bi-directional many-to-one association to VerticalUser
	@Getter @Setter
	@OneToMany(mappedBy="user")
	private List<VerticalUser> verticalUsers;


	/**
	 * Adiciona uma agenda ao usuario, a principio ele poderia abrir
	 * mais de uma agenda.
	 * 
	 * Não usar, o sistema não vai permitir que sejam criadas mais de uma
	 * agenda por usuario.
	 * 
	 * @param agenda
	 * @return
	 */
	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setUser(this);

		return agenda;
	}

	/**
	 * Não usar, o sistema não vai permitir que sejam criadas mais de uma
	 * agenda por usuario.
	 * 
	 * @param agenda
	 * @return
	 */
	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setUser(null);

		return agenda;
	}

	/**
	 * 
	 * @param compromissos
	 * @return
	 */
	public Compromisso addCompromissosComUsuario(Compromisso compromissos) {
		getCompromissosComUsuario().add(compromissos);
		compromissos.setUserTo(this);
		return compromissos;
	}

	/**
	 * 
	 * @param compromissos
	 * @return
	 */
	public Compromisso removeCompromissosComUsuario(Compromisso compromissos) {
		getCompromissosComUsuario().remove(compromissos);
		compromissos.setUserTo(null);
		return compromissos;
	}

	/**
	 * 
	 * @param compromissos
	 * @return
	 */
	public Compromisso addCompromissosDoUsuario(Compromisso compromissos) {
		getCompromissosDoUsuario().add(compromissos);
		compromissos.setUserFrom(this);
		return compromissos;
	}

	/**
	 * 
	 * @param compromissos
	 * @return
	 */
	public Compromisso removeCompromissosDoUsuario(Compromisso compromissos) {
		getCompromissosDoUsuario().remove(compromissos);
		compromissos.setUserFrom(null);
		return compromissos;
	}

	/**
	 * 
	 * @param contato
	 * @return
	 */
	public Contato addContato(Contato contato) {
		getContatos().add(contato);
		contato.setUser(this);

		return contato;
	}

	/**
	 * 
	 * @param contato
	 * @return
	 */
	public Contato removeContato(Contato contato) {
		getContatos().remove(contato);
		contato.setUser(null);

		return contato;
	}

	/**
	 * 
	 * @param conversaCompromisso
	 * @return
	 */
	public ConversaCompromisso addConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().add(conversaCompromisso);
		conversaCompromisso.setUser(this);

		return conversaCompromisso;
	}

	/**
	 * 
	 * @param conversaCompromisso
	 * @return
	 */
	public ConversaCompromisso removeConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().remove(conversaCompromisso);
		conversaCompromisso.setUser(null);

		return conversaCompromisso;
	}

	/**
	 * 
	 * @param dadosCobranca
	 * @return
	 */
	public DadosCobranca addDadosCobranca(DadosCobranca dadosCobranca) {
		getDadosCobrancas().add(dadosCobranca);
		dadosCobranca.setUser(this);

		return dadosCobranca;
	}

	/**
	 * 
	 * @param dadosCobranca
	 * @return
	 */
	public DadosCobranca removeDadosCobranca(DadosCobranca dadosCobranca) {
		getDadosCobrancas().remove(dadosCobranca);
		dadosCobranca.setUser(null);

		return dadosCobranca;
	}

	/**
	 * 
	 * @param verticalUser
	 * @return
	 */
	public VerticalUser addVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().add(verticalUser);
		verticalUser.setUser(this);
		return verticalUser;
	}

	/**
	 * 
	 * @param verticalUser
	 * @return
	 */
	public VerticalUser removeVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().remove(verticalUser);
		verticalUser.setUser(null);

		return verticalUser;
	}

}