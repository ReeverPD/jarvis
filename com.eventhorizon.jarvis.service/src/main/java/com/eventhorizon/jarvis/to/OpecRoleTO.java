package com.eventhorizon.jarvis.to;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

/**
 * TO do Role dos usuarios da OPEC
 * @author iuriandreazza
 */
public class OpecRoleTO implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7489156277700854379L;
	
	@Getter @Setter
	private String name;
	
	@Override
	public String getAuthority() {
		return this.getName();
	}

	public OpecRoleTO(String name){
		this.setName(name);
	}
	
}
