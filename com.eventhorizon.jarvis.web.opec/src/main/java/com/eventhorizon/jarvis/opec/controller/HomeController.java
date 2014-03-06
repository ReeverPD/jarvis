package com.eventhorizon.jarvis.opec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventhorizon.jarvis.opec.util.UrlMapping;

/**
 * Controller do Dashboard e Home do JARVIS OPEC
 * 
 * 
 * @author iuriandreazza
 */
@Controller
public class HomeController extends AbstractController {

	/**
	 * Home base and root controller
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = { UrlMapping.ROOT_URL, UrlMapping.HOME_URL })
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return new ModelAndView("home", model);
	}
	
	/**
	 * Redirect from ROOT Dir to /app/home
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
//	@RequestMapping(method = RequestMethod.GET, value = UrlMapping.ROOT_FULL_URL)
//	public ModelAndView rootRedirect(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//        if(!this.opecUserService.isAutenticated()){
//            return new ModelAndView("redirect:"+UrlMapping.LOGIN_URL);
//        }
//        return new ModelAndView("redirect:"+UrlMapping.ROOT_URL);
//	}
	
	
}
