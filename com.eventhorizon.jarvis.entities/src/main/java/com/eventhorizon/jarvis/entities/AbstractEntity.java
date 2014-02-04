package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


/**
 * Entidade Base
 * 
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
@SuppressWarnings("serial")
public class AbstractEntity<T extends Object> implements Serializable {

	@Setter
	@Getter 
    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private T Id;
	
	
	
}
