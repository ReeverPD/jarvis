package com.eventhorizon.jarvis.opec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventhorizon.jarvis.opec.util.UrlMapping;
import com.eventhorizon.jarvis.security.JarvisOpecAuthenticationProvider;
import com.eventhorizon.jarvis.service.impl.OpecUserService;


@Controller
public class LoginController extends AbstractController {

	private Logger log = LoggerFactory.getLogger(LoginController.class); 
	
	@Autowired
	private JarvisOpecAuthenticationProvider authenticationProvider;
	
	@Autowired
	private OpecUserService opecUserService1;
	
	/**
	 * Login controller GET Login Screen
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = { UrlMapping.LOGIN_URL })
    public ModelAndView handleLoginRequest(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		log.info(">>>>>>> OpecProv"+authenticationProvider);
		log.info(">>>>>>> OpecRepo"+opecUserRepository);
		log.info(">>>>>>> OpecServ"+opecUserService1);
		
		
		
		return new ModelAndView("login", model);
	
	}
	
	/**
	 * Handle Post from Login Page
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
//	@RequestMapping(method = RequestMethod.POST, value = { UrlMapping.LOGIN_AUTH_URL })
//    public void handleAuthPost(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		//Authentication authentication = new ;
//		UsernamePasswordAuthenticationToken token = this.authenticationProvider.authenticate(authentication);
//		SecurityContextHolder.createEmptyContext();
//		SecurityContextHolder.getContext().setAuthentication(token);
//	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = { UrlMapping.LOGIN_ERROR_URL })
	public ModelAndView handleLoginRequestError(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		log.info(">>>>>>> OpecProv"+authenticationProvider);
		log.info(">>>>>>> OpecRepo"+opecUserRepository);
		
		model.addAttribute("loginError", true);
		return new ModelAndView("login", model);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = { UrlMapping.LOGIN_ACCESS_DENIED_URL })
	public ModelAndView handleLoginRequestAccessDenied(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return new ModelAndView("accessDenied", model);
	}

	
	
}
