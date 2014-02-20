package com.eventhorizon.jarvis.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eventhorizon.jarvis.service.IOpecUserService;
import com.eventhorizon.jarvis.service.impl.OpecUserService;
import com.eventhorizon.jarvis.to.OpecUserTO;

/**
 * Provider de autenticacao do OPEC
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
@Service
public class JarvisOpecAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private IOpecUserService opecUserService;
	
	@Autowired
	private OpecUserService opecUserService1;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        System.out.println(">>>>> service "+opecUserService);
        System.out.println(">>>>> service "+opecUserService1);
        
        OpecUserTO user = opecUserService.findByUsernamePassword(username, password);
        
        if(user == null){
        	throw new BadCredentialsException("Usuario inexistente.");
        }
        
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	
	
}
