package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String activationToken;
	private String descricao;
	private String email;
	private String nome;
	private String password;
	private String profile_Cover;
	private String profile_Id;
	private String profile_Link;
	private String profile_Picture;
	private String profile_Token;
	private String sobrenome;
	private String social_Media_Type;
	private String tipoUsuario;
	private String username;
	private List<Agenda> agendas;
	private List<Compromisso> compromissos1;
	private List<Compromisso> compromissos2;
	private List<Contato> contatos;
	private List<ConversaCompromisso> conversaCompromissos;
	private List<DadosCobranca> dadosCobrancas;
	private List<VerticalUser> verticalUsers;

	public User() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getActivationToken() {
		return this.activationToken;
	}

	public void setActivationToken(String activationToken) {
		this.activationToken = activationToken;
	}


	@Lob
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getProfile_Cover() {
		return this.profile_Cover;
	}

	public void setProfile_Cover(String profile_Cover) {
		this.profile_Cover = profile_Cover;
	}


	public String getProfile_Id() {
		return this.profile_Id;
	}

	public void setProfile_Id(String profile_Id) {
		this.profile_Id = profile_Id;
	}


	public String getProfile_Link() {
		return this.profile_Link;
	}

	public void setProfile_Link(String profile_Link) {
		this.profile_Link = profile_Link;
	}


	public String getProfile_Picture() {
		return this.profile_Picture;
	}

	public void setProfile_Picture(String profile_Picture) {
		this.profile_Picture = profile_Picture;
	}


	public String getProfile_Token() {
		return this.profile_Token;
	}

	public void setProfile_Token(String profile_Token) {
		this.profile_Token = profile_Token;
	}


	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getSocial_Media_Type() {
		return this.social_Media_Type;
	}

	public void setSocial_Media_Type(String social_Media_Type) {
		this.social_Media_Type = social_Media_Type;
	}


	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	//bi-directional many-to-one association to Agenda
	@OneToMany(mappedBy="user")
	public List<Agenda> getAgendas() {
		return this.agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Agenda addAgenda(Agenda agenda) {
		getAgendas().add(agenda);
		agenda.setUser(this);

		return agenda;
	}

	public Agenda removeAgenda(Agenda agenda) {
		getAgendas().remove(agenda);
		agenda.setUser(null);

		return agenda;
	}


	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="user1")
	public List<Compromisso> getCompromissos1() {
		return this.compromissos1;
	}

	public void setCompromissos1(List<Compromisso> compromissos1) {
		this.compromissos1 = compromissos1;
	}

	public Compromisso addCompromissos1(Compromisso compromissos1) {
		getCompromissos1().add(compromissos1);
		compromissos1.setUser1(this);

		return compromissos1;
	}

	public Compromisso removeCompromissos1(Compromisso compromissos1) {
		getCompromissos1().remove(compromissos1);
		compromissos1.setUser1(null);

		return compromissos1;
	}


	//bi-directional many-to-one association to Compromisso
	@OneToMany(mappedBy="user2")
	public List<Compromisso> getCompromissos2() {
		return this.compromissos2;
	}

	public void setCompromissos2(List<Compromisso> compromissos2) {
		this.compromissos2 = compromissos2;
	}

	public Compromisso addCompromissos2(Compromisso compromissos2) {
		getCompromissos2().add(compromissos2);
		compromissos2.setUser2(this);

		return compromissos2;
	}

	public Compromisso removeCompromissos2(Compromisso compromissos2) {
		getCompromissos2().remove(compromissos2);
		compromissos2.setUser2(null);

		return compromissos2;
	}


	//bi-directional many-to-one association to Contato
	@OneToMany(mappedBy="user")
	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato addContato(Contato contato) {
		getContatos().add(contato);
		contato.setUser(this);

		return contato;
	}

	public Contato removeContato(Contato contato) {
		getContatos().remove(contato);
		contato.setUser(null);

		return contato;
	}


	//bi-directional many-to-one association to ConversaCompromisso
	@OneToMany(mappedBy="user")
	public List<ConversaCompromisso> getConversaCompromissos() {
		return this.conversaCompromissos;
	}

	public void setConversaCompromissos(List<ConversaCompromisso> conversaCompromissos) {
		this.conversaCompromissos = conversaCompromissos;
	}

	public ConversaCompromisso addConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().add(conversaCompromisso);
		conversaCompromisso.setUser(this);

		return conversaCompromisso;
	}

	public ConversaCompromisso removeConversaCompromisso(ConversaCompromisso conversaCompromisso) {
		getConversaCompromissos().remove(conversaCompromisso);
		conversaCompromisso.setUser(null);

		return conversaCompromisso;
	}


	//bi-directional many-to-one association to DadosCobranca
	@OneToMany(mappedBy="user")
	public List<DadosCobranca> getDadosCobrancas() {
		return this.dadosCobrancas;
	}

	public void setDadosCobrancas(List<DadosCobranca> dadosCobrancas) {
		this.dadosCobrancas = dadosCobrancas;
	}

	public DadosCobranca addDadosCobranca(DadosCobranca dadosCobranca) {
		getDadosCobrancas().add(dadosCobranca);
		dadosCobranca.setUser(this);

		return dadosCobranca;
	}

	public DadosCobranca removeDadosCobranca(DadosCobranca dadosCobranca) {
		getDadosCobrancas().remove(dadosCobranca);
		dadosCobranca.setUser(null);

		return dadosCobranca;
	}


	//bi-directional many-to-one association to VerticalUser
	@OneToMany(mappedBy="user")
	public List<VerticalUser> getVerticalUsers() {
		return this.verticalUsers;
	}

	public void setVerticalUsers(List<VerticalUser> verticalUsers) {
		this.verticalUsers = verticalUsers;
	}

	public VerticalUser addVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().add(verticalUser);
		verticalUser.setUser(this);

		return verticalUser;
	}

	public VerticalUser removeVerticalUser(VerticalUser verticalUser) {
		getVerticalUsers().remove(verticalUser);
		verticalUser.setUser(null);

		return verticalUser;
	}

}