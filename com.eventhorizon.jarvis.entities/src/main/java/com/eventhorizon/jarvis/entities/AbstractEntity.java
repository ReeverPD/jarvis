package com.eventhorizon.jarvis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;


/**
 * Entidade Base
 * 
 * @author Iuri Andreazza { iuri.andreazza@reeverpd.com.br }
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class AbstractEntity<T extends Object> implements Serializable {

	@Setter
	@Getter 
    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private T Id;
	
	
}
