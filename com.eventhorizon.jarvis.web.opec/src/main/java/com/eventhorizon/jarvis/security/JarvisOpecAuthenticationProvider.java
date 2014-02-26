package com.eventhorizon.jarvis.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.eventhorizon.jarvis.service.IOpecUserService;
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
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
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
