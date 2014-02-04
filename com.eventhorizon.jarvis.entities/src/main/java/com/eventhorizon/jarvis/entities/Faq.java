package com.eventhorizon.jarvis.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Faq database table.
 * 
 */
@Entity
@NamedQuery(name="Faq.findAll", query="SELECT f FROM Faq f")
public class Faq extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;
	private int nro;
	private String quantInutil;
	private int quantUtil;
	private String titulo;

	public Faq() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Lob
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getNro() {
		return this.nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}


	public String getQuantInutil() {
		return this.quantInutil;
	}

	public void setQuantInutil(String quantInutil) {
		this.quantInutil = quantInutil;
	}


	public int getQuantUtil() {
		return this.quantUtil;
	}

	public void setQuantUtil(int quantUtil) {
		this.quantUtil = quantUtil;
	}


	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}