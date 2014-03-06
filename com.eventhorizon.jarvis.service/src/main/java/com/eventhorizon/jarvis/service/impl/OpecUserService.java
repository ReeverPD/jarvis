package com.eventhorizon.jarvis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.eventhorizon.jarvis.entity.CMSUser;
import com.eventhorizon.jarvis.repository.IOpecUserRepository;
import com.eventhorizon.jarvis.repository.IRepository;
import com.eventhorizon.jarvis.service.AbstractService;
import com.eventhorizon.jarvis.service.IOpecUserService;
import com.eventhorizon.jarvis.to.OpecUserTO;

@Service
public class OpecUserService extends AbstractService<CMSUser, Long> implements
		IOpecUserService {

	@Autowired
	private IOpecUserRepository opecRepository;

	@Override
	public boolean existsUser(String username) {
		return opecRepository.findByUsername(username) != null;
	}

	@Override
	public OpecUserTO findByUsernamePassword(String username, String password) {
		CMSUser user = opecRepository
				.findByUsernamePassword(username, password);
		if (user == null) {
			return null;
		}
		OpecUserTO userTO = fillUserTO(user);
		return userTO;
	}

	@Override
	public OpecUserTO findByUsername(String username) {
		return fillUserTO(this.opecRepository.findByUsername(username));
	}

	@Override
	public OpecUserTO findUserByToken(String token) {
		return fillUserTO(this.opecRepository.findUserByToken(token));
	}

	@Override
	public IRepository<CMSUser, Long> getRepository() {
		return this.opecRepository;
	}

	/**
	 * @param user
	 * @return
	 */
	protected OpecUserTO fillUserTO(CMSUser user) {
		if (user == null) {
			return null;
		}
		OpecUserTO userTO = new OpecUserTO();
		userTO.setAtivo(user.getAtivo());
		userTO.setEmail(user.getEmail());
		userTO.setId(user.getId());
		userTO.setPicture(user.getPicture());
		userTO.setUsername(user.getUsername());
		return userTO;
	}


    /**
     *
     * @return
     */
    public boolean isAutenticated(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !auth.getName().equalsIgnoreCase("anonymousUser");
    }

}
