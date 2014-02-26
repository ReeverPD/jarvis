package com.eventhorizon.jarvis.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author iuriandreazza
 */
public class OpecUserTO implements Serializable {

	private static final long serialVersionUID = 3093306946587361600L;
	
	@Getter @Setter
	private Long Id;
	
	@Getter @Setter
	private String ativo;

	@Getter @Setter
	private String email;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private String picture;
	
	@Getter @Setter
	private String username;
	
	//para o OPEC isso é fixo (por enquanto)
	@Setter
	private List<OpecRoleTO> Authorities;

	
	public List<OpecRoleTO> getAuthorities(){
		List<OpecRoleTO> lst = new ArrayList<OpecRoleTO>();
		lst.add(new OpecRoleTO("ROLE_ADMIN"));
		lst.add(new OpecRoleTO("ROLE_USER"));
		lst.add(new OpecRoleTO("ROLE_MANAGER"));
		this.setAuthorities(lst);
		return this.Authorities;
	}
	
}
