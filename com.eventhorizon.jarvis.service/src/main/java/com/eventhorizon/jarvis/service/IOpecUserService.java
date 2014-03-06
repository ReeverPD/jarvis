package com.eventhorizon.jarvis.service;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.to.OpecUserTO;

public interface IOpecUserService extends IService<CMSUser, Long> {
	
	/**
	 * Verifica se existe usuario com o username
	 * 
	 * @param username
	 * @return
	 */
	boolean existsUser(String username);
	
	/**
	 * Procura por usuario + pass
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	OpecUserTO findByUsernamePassword(String username, String password);
	
	/**
	 * Procura por usuario somente pelo seu username
	 * @param username
	 * @return
	 */
	OpecUserTO findByUsername(String username);
	
	/**
	 * Autentica usuario no modo superusuario
	 * 
	 * @param token
	 * @return
	 */
	OpecUserTO findUserByToken(String token);

    /**
     * Verify inside the Spring Security when the user is autenticated or not.
     * @return
     */
    boolean isAutenticated();
	
}
