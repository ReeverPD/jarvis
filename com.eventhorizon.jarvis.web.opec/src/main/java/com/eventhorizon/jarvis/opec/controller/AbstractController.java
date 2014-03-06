package com.eventhorizon.jarvis.opec.controller;

import com.eventhorizon.jarvis.opec.web.ui.BreadcrumbItem;
import com.eventhorizon.jarvis.service.IOpecUserService;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.eventhorizon.jarvis.repository.IOpecUserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
public class AbstractController {

	@Getter
	@Autowired
	protected IOpecUserService opecUserService;

    @Getter
    protected List<BreadcrumbItem> lstBreadcrumb = new ArrayList<>();


	public void getLoggedUser() {
		SecurityContextHolder.getContext().getAuthentication().getCredentials();
	}
	
	
}
