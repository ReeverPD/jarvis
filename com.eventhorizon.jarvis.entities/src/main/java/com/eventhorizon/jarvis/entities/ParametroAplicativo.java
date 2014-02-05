package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the ParametroAplicativo database table.
 * 
 */
@Entity
public class ParametroAplicativo extends AbstractEntity<Long> implements Serializable {

	@Getter @Setter
	private String ativo;

	@Getter @Setter
	private String grupo;
	
	@Getter @Setter
	private String parametro;
	
	@Getter @Setter
	private String valor;

}