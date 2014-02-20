package com.eventhorizon.jarvis.opec.controller;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;

import com.eventhorizon.jarvis.repository.IOpecUserRepository;

/**
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
public class AbstractController {

	@Getter
	@Autowired
	protected IOpecUserRepository opecUserRepository;
	
	
	
}
