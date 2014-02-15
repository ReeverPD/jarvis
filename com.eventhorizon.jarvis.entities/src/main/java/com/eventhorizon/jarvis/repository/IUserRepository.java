package com.eventhorizon.jarvis.repository;

import com.eventhorizon.jarvis.entity.CMSUser;

/**
 * Classe de integracao com o CMS Users para autenticar e gerenciar
 * usuarios do J.A.R.V.I.S - OPEC
 * 
 * @author Iuri Andreazza { iuri.andreazza@gmail.com }
 */
public interface IUserRepository extends IRepository<CMSUser, Long> {

	/**
	 * Procura por usuario + pass
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	CMSUser findByUsernamePassword(String username, String password);
	
	/**
	 * Procura por usuario somente pelo seu username
	 * @param username
	 * @return
	 */
	CMSUser findByUsername(String username);
	
	/**
	 * Autentica usuario no modo superusuario
	 * 
	 * @param token
	 * @return
	 */
	CMSUser findUserByToken(String token);
	
	
	
}
