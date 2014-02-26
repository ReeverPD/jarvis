package com.eventhorizon.jarvis.opec.controller;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.eventhorizon.jarvis.repository.IOpecUserRepository;

/**
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
public class AbstractController {

	@Getter
	@Autowired
	protected IOpecUserRepository opecUserRepository;
	
	public void getLoggedUser() {
		SecurityContextHolder.getContext().getAuthentication().getCredentials();
	}
	
	
}
