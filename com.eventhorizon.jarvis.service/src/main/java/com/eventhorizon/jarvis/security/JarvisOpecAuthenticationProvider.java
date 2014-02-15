package com.eventhorizon.jarvis.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Provider de autenticacao do OPEC
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
@Component
public class JarvisOpecAuthenticationProvider implements AuthenticationProvider {

	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
