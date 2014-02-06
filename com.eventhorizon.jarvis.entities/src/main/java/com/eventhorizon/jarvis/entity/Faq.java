package com.eventhorizon.jarvis.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the Faq database table.
 * 
 */
@Entity
@NamedQuery(name="Faq.findAll", query="SELECT f FROM Faq f")
public class Faq extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = -241618668205490447L;

	@Getter @Setter
	@Lob
	private String descricao;

	@Getter @Setter
	private int nro;
	
	@Getter @Setter
	private int quantInutil;
	
	@Getter @Setter
	private int quantUtil;
	
	@Getter @Setter
	private String titulo;
	

//	@Lob
//	public String getDescricao() {
//		return this.descricao;
//	}
	

}