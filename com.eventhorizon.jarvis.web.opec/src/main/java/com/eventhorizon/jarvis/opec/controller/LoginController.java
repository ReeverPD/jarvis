package com.eventhorizon.jarvis.opec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventhorizon.jarvis.opec.util.UrlMapping;


@Controller
public class LoginController extends AbstractController {

	/**
	 * Login controller GET Login Screen
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = { UrlMapping.LOGIN_URL })
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		
		
		return new ModelAndView("login", model);
	
	}
	
}
