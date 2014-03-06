package com.eventhorizon.jarvis.opec.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eventhorizon.jarvis.opec.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eventhorizon.jarvis.opec.web.ui.NavBar;
import com.eventhorizon.jarvis.service.IOpecUserService;
import com.eventhorizon.jarvis.to.OpecUserTO;

/**
 * 
 * @author iuriandreazza
 *
 */
public class OpecPageInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(OpecPageInterceptor.class);
	
	@Autowired
	private IOpecUserService opecUserService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
        if(mav != null){
        	//Menus (NavBar)
        	NavBar nav = new NavBar();
        	mav.addObject("menus", nav.getMenus());
            mav.addObject("lang", "pt-BR");

            mav.addObject("", ((AbstractController)handler).getLstBreadcrumb());

        	mav.addObject("year", Calendar.getInstance().get(Calendar.YEAR));
        	
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        	if(auth != null 
        			&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
        			&& !auth.getName().equalsIgnoreCase("anonymousUser")) {
        		OpecUserTO userTO = opecUserService.findByUsername(auth.getName());
        		mav.addObject("userPicture", userTO.getPicture());
            	mav.addObject("userName", userTO.getUsername());
        	}


            long startTime = (Long)request.getAttribute("startTime");
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            mav.addObject("executeTime",executeTime);

            //log it
            if(log.isDebugEnabled()){
                log.debug("[" + handler + "] executeTime : " + executeTime + "ms");
            }
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception excptn) throws Exception {
        
    }
    

	
}
